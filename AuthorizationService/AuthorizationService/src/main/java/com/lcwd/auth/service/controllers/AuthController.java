package com.lcwd.auth.service.controllers;

import com.lcwd.auth.service.dto.AuthRequest;
import com.lcwd.auth.service.entity.UserCredentials;
import com.lcwd.auth.service.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController
{

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addUser(@RequestBody UserCredentials userCredentials)
    {
        return authService.addUser(userCredentials);
    }

    // To generate the token
    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest)
    {
      Authentication authenticate=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
      if(authenticate.isAuthenticated())
      {
          return authService.getToken(authRequest.getUserName());
      }
      else {
          throw new RuntimeException("Not a valid user");
      }
    }

    @GetMapping("/validate")
    public  String validateToken(@RequestParam("token") String token)
    {
        authService.validateToken(token);
        return "Token is valid";
    }

}
