package com.lcwd.user.service.services;

import com.lcwd.user.service.entity.User;

import java.util.List;

public interface UserService
{
    //get all user
    List<User> getAllUsers();

    //get user by id
    User getUserById(int user_id);

    //add user
    User addUser(User user);
}
