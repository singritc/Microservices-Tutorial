package com.lcwd.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hotelId;
    private String hotelName;
    private String location;
}
