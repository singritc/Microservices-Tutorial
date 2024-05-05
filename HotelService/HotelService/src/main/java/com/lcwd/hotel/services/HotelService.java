package com.lcwd.hotel.services;

import com.lcwd.hotel.entity.Hotel;

import java.util.List;

public interface HotelService
{
    //create or add new Hotel
    Hotel addHotel(Hotel hotel);
    //get all Hotels
    List<Hotel> getAllHotels();

    //get Hotel by id

    Hotel getHotelById(int hotelId);
}
