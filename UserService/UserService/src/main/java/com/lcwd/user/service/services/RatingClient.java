package com.lcwd.user.service.services;

import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATING-SERVICE")
public interface RatingClient
{
    @GetMapping("ratings/user/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable int userId);

}
