package com.lcwd.rating.controller;


import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ratings")
public class RatingController
{
    @Autowired
    private RatingService ratingService;
    //create new rating

    @PostMapping
    public ResponseEntity<Rating>  addNewRating(@RequestBody Rating rating)
    {
        Rating added = ratingService.addRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(added);
    }
    //gett all ratings

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        List<Rating> allratings = ratingService.getAllratings();
        return ResponseEntity.status(HttpStatus.OK).body(allratings);
    }

    //get ratings by id
    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingByRatingId(@PathVariable int ratingId)
    {
        Rating ratingById = ratingService.getRatingById(ratingId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingById);
    }

    //get ratings by user id

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable int userId)
    {
        List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);
    }

    //get ratings by hotel id

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable int hotelId)
    {
        List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByHotelId);
    }
}
