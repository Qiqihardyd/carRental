package com.example.rentalsystem.service;

import com.example.rentalsystem.model.RentalLocation;
import com.example.rentalsystem.repository.RentalLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalLocationServiceImpl implements RentalLocationService {

    @Autowired
    private RentalLocationRepository rentalLocationRepository;

    @Override
    public RentalLocation save(RentalLocation rentalLocation) {
        return rentalLocationRepository.save(rentalLocation);
    }
    
    @Override
    public List<RentalLocation> findAll() {
        return rentalLocationRepository.findAll();
    }

    @Override
    public RentalLocation findById(Long id) {
        return rentalLocationRepository.findById(id).orElse(null);
    }
}