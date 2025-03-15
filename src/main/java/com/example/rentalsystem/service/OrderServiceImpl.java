package com.example.rentalsystem.service;

import com.example.rentalsystem.model.Order;
import com.example.rentalsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

   @Autowired
   private OrderRepository orderRepository;

   @Override
   public Order save(Order order) {
       return orderRepository.save(order);
   }

   @Override
   public Order findById(Long id) {
       return orderRepository.findById(id).orElse(null);
   }
}