package com.examly.springapp.service;

import com.examly.springapp.model.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Integer userId);
}
