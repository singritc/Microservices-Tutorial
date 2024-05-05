package com.lcwd.auth.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserCredentials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String password;
    private String email;
}
