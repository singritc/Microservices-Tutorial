package com.lcwd.user.service.controller;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.services.UserService;
import com.lcwd.user.service.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    // create users
    @PostMapping()
   public ResponseEntity<User> addUser(@RequestBody User user)
   {
       User saved = userService.addUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(saved);
   }

   //get all users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    //get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id)
    {
        try
        {
            User userById = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(userById);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
