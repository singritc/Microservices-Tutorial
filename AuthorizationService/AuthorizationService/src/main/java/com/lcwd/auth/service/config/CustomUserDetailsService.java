package com.lcwd.auth.service.config;

import com.lcwd.auth.service.entity.UserCredentials;
import com.lcwd.auth.service.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<UserCredentials> credentials =userCredentialsRepository.findByUserName(username);
        return credentials.map(CustomUserDetails::new).orElseThrow(()->new RuntimeException("User not found with username= "+ username));
    }
}
