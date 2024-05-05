package com.lcwd.auth.service.services;

import com.lcwd.auth.service.entity.UserCredentials;
import com.lcwd.auth.service.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    // add or save a new user
    public String addUser(UserCredentials userCredentials)
    {
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        userCredentialsRepository.save(userCredentials);
        return  "User Added to the System";
    }

    // get token for the user
    public String getToken(String userName)
    {
        return jwtService.generateToken(userName);
    }

    //to validate token
    public void validateToken(String token)
    {
        jwtService.validateToken(token);
    }
}
