package com.lcwd.rating.services;

import com.lcwd.rating.entity.Rating;

import java.util.List;

public interface RatingService
{
    //create new rating

    Rating addRating(Rating rating);

    //getall ratings
    List<Rating> getAllratings();

    // get ratings bu rating id
    Rating getRatingById(int ratingId);
    //get ratings by user id
    List<Rating> getRatingByUserId(int userId);
    //get ratings bu hotel id

    List<Rating> getRatingByHotelId(int hotelId);
}
