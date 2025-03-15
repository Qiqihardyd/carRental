package com.example.rentalsystem.service;

import com.example.rentalsystem.model.Car;
import java.util.List;

public interface CarService {
    Car save(Car car);
    List<Car> findAll();
    Car findByLicensePlate(String licensePlate);
    Car findById(Long id);
    List<Car> findAvailableCars();
}