package com.lcwd.hotel.controller;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController
{
    @Autowired
    private HotelService hotelService;
    //add or create new Hotel
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel)
    {
        Hotel add = hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(add);
    }
    //get all hotels

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(allHotels);
    }

    //get hotel by id

    @GetMapping("/{hotelId}")
    public  ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId)
    {
        Hotel hotelById = hotelService.getHotelById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotelById);
    }
}
