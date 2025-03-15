package com.example.rentalsystem.repository;

import com.example.rentalsystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // 自定义查询方法
}
