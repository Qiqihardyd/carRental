package com.example.rentalsystem.repository;

import com.example.rentalsystem.model.RentalLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalLocationRepository extends JpaRepository<RentalLocation, Long> {
    // 自定义查询方法
}
