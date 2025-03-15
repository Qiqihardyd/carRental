package com.example.rentalsystem.service;

import com.example.rentalsystem.model.RentalLocation;
import java.util.List;

public interface RentalLocationService {
    RentalLocation save(RentalLocation rentalLocation);
    List<RentalLocation> findAll();
    RentalLocation findById(Long id);
}