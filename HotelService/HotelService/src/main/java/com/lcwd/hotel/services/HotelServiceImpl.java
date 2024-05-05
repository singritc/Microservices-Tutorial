package com.lcwd.hotel.services;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.repositories.HotelRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService
{

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels()
    {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(int hotelId)
    {
        return hotelRepository.findById(hotelId).orElseThrow(()->new RuntimeException("Hotel not Found"));
    }
}
