package com.lcwd.rating.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel
{

    private int hotelId;
    @Transient
    private int ratingId;
    private String hotelName;
    private String location;
}