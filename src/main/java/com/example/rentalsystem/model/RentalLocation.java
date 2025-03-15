package com.example.rentalsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "rental_locations")
public class RentalLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    // 其他租车点信息字段

    // 构造函数
    public RentalLocation() {
    }

    public RentalLocation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}