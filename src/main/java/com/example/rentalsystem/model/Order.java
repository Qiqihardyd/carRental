package com.example.rentalsystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 订单日期，非空
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    // 租赁天数，非空，默认值为0
    @Column(name = "rental_days", nullable = false)
    private Integer rentalDays;

    // 总费用，非空
    @Column(name = "total_cost", nullable = false)
    private Double totalCost;

    // 车辆关联
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    // 取车地点关联
    @ManyToOne
    @JoinColumn(name = "pickup_location_id", referencedColumnName = "id")
    private RentalLocation pickupLocation;

    // 还车地点关联
    @ManyToOne
    @JoinColumn(name = "dropoff_location_id", referencedColumnName = "id")
    private RentalLocation dropoffLocation;

    // 用户关联
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // 取车和还车日期
    @Column(name = "pickup_date")
    private LocalDateTime pickupDate;

    @Column(name = "dropoff_date")
    private LocalDateTime dropoffDate;

    // 总价格（可为空）
    @Column(name = "total_price")
    private Double totalPrice;

    // 订单状态
    private String status;

    // 构造函数
    public Order() {
    }

    // Getter 和 Setter 方法

    // id
    public Long getId() {
        return id;
    }

    // orderDate
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    // rentalDays
    public Integer getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(Integer rentalDays) {
        this.rentalDays = rentalDays;
    }

    // totalCost
    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    // car
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    // pickupLocation
    public RentalLocation getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(RentalLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    // dropoffLocation
    public RentalLocation getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(RentalLocation dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    // user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // pickupDate
    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    // dropoffDate
    public LocalDateTime getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDateTime dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    // totalPrice
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}