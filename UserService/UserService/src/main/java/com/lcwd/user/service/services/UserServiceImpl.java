package com.lcwd.user.service.services;

import com.lcwd.user.service.entity.Hotel;
import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService
{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RatingClient ratingClient;

    @Autowired
    private HotelClient hotelClient;
    @Override
    public List<User> getAllUsers()
    {
        List<User> allUsers = userRepository.findAll();

        // setting ratings of user by calling RATING-SERVICE through Feign Client
        List<User> collect = allUsers.stream().map(user -> {

            List<Rating> ratingByUserId = ratingClient.getRatingByUserId(user.getUser_id());

            List<Rating> ratingList=ratingByUserId.stream().map(rating -> {
                Hotel hotel=hotelClient.getHotelByHotelId(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());

                    user.setRatings(ratingList);
                    return user;
                }
        ).collect(Collectors.toList());

        return collect;
    }

    @Override
    public User getUserById(int user_id)
    {
        // Finding user by userId
        User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User Not found"));
        // Fetching rating list of the user
        List<Rating> ratingByUserId = ratingClient.getRatingByUserId(user.getUser_id());

        // setting hotel to the rating list
        List<Rating> ratingList=ratingByUserId.stream().map(rating -> {
            Hotel hotel=hotelClient.getHotelByHotelId(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User addUser(User user)
    {
        return userRepository.save(user);
    }
}
