package com.example.rentalsystem.service;

import com.example.rentalsystem.model.Car;
import com.example.rentalsystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }
    
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> findAvailableCars() {
        return carRepository.findByAvailable(true);
    }
}