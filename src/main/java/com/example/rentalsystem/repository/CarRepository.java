package com.example.rentalsystem.repository;

import com.example.rentalsystem.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByLicensePlate(String licensePlate);
    List<Car> findByAvailable(Boolean available);
}

