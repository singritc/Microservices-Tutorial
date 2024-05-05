package com.lcwd.rating.services;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService
{

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Rating addRating(Rating rating)
    {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllratings()
    {
        List<Rating> all = ratingRepository.findAll();
        return all;
    }

    @Override
    public Rating getRatingById(int ratingId)
    {
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(() -> new RuntimeException("rating not found"));
        return rating;
    }

    @Override
    public List<Rating> getRatingByUserId(int userId)
    {
        return ratingRepository.findByUserId(userId);

    }

    @Override
    public List<Rating> getRatingByHotelId(int hotelId)
    {
        return ratingRepository.findByHotelId(hotelId);

    }
}
