package com.example.rentalsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"license_plate"})
})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 型号
    @NotNull(message = "型号不能为空")
    private String model;

    // 车牌
    @Column(name = "license_plate", unique = true)
    @NotNull(message = "车牌不能为空")
    private String licensePlate;
    private Double pricePerDay;
    private Boolean available;

    // 构造函数
    public Car() {
    }

    public Car(String model, String licensePlate, Double pricePerDay, Boolean available) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.pricePerDay = pricePerDay;
        this.available = available;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    // 型号
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // 车牌
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}