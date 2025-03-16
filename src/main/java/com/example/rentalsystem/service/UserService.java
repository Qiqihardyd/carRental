package com.example.rentalsystem.service;

import com.example.rentalsystem.model.User;

public interface UserService {
    void register(User user);
    User login(String username, String password);
    void registerAdmin(User user);
    User findByUsername(String username);
}
