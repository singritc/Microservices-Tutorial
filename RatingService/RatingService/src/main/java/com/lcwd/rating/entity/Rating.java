package com.lcwd.rating.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rating_id")
    private int ratingId;
    @Column(name="user_id")
    private int userId;
    @Column(name="hotel_id")
    private int hotelId;
    private int rating;
    private String feedback;

}
