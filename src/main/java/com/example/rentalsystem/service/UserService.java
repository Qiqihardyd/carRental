package com.example.rentalsystem.service;

import com.example.rentalsystem.model.User;

public interface UserService {
    void register(User user);
    User login(String username, String password);
    User findByUsername(String username);
}
