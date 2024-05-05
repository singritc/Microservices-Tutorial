package com.lcwd.auth.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConfig
{
    @Bean
    public UserDetailsService userDetailsService()
    {
        return new CustomUserDetailsService();
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
   {
       return http.csrf().disable()
               .authorizeHttpRequests()
               .requestMatchers("/auth/register","/auth/generateToken","/auth/validate")
               .permitAll().and().build();
   }

   @Bean
    public AuthenticationProvider authenticationProvider()
   {
       DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
       daoAuthenticationProvider.setUserDetailsService(userDetailsService());
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
       return daoAuthenticationProvider;

   }


}
