package com.example.rentalsystem.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class OrderForm {
    private Long carId;
    private Long pickupLocationId;
    private Long dropoffLocationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickupDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropoffDate;

    // Getter 和 Setter 方法

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getPickupLocationId() {
        return pickupLocationId;
    }

    public void setPickupLocationId(Long pickupLocationId) {
        this.pickupLocationId = pickupLocationId;
    }

    public Long getDropoffLocationId() {
        return dropoffLocationId;
    }

    public void setDropoffLocationId(Long dropoffLocationId) {
        this.dropoffLocationId = dropoffLocationId;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDate dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
}