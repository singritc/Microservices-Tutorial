package com.lcwd.user.service.services;

import com.lcwd.user.service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelClient
{

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotelByHotelId(@PathVariable int hotelId);
}
