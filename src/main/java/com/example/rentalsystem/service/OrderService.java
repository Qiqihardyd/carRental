package com.example.rentalsystem.service;

import com.example.rentalsystem.model.Order;

public interface OrderService {
    Order save(Order order);
    Order findById(Long id);
}