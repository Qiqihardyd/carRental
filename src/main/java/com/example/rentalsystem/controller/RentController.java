package com.example.rentalsystem.controller;

import com.example.rentalsystem.model.Car;
import com.example.rentalsystem.model.OrderForm;
import com.example.rentalsystem.model.RentalLocation;
import com.example.rentalsystem.service.CarService;
import com.example.rentalsystem.service.RentalLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import com.example.rentalsystem.model.User;
import com.example.rentalsystem.service.UserService;
import com.example.rentalsystem.model.Order;
import com.example.rentalsystem.service.OrderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private CarService carService;

    @Autowired
    private RentalLocationService rentalLocationService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    // 显示租车页面
    @GetMapping
    public String showRentForm(Model model) {
        List<Car> cars = carService.findAvailableCars();
        List<RentalLocation> locations = rentalLocationService.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("locations", locations);
        model.addAttribute("orderForm", new OrderForm());
        return "rent";
    }

    // 处理租车表单提交
    @PostMapping
    public String processRentForm(@ModelAttribute OrderForm orderForm, Model model, Authentication authentication) {
        // 获取选择的车辆
        Car car = carService.findById(orderForm.getCarId());
        if (car == null || !car.getAvailable()) {
            model.addAttribute("error", "选择的车辆不可用");
            return "rent";
        }

        // 检查日期
        LocalDate pickupDate = orderForm.getPickupDate();
        LocalDate dropoffDate = orderForm.getDropoffDate();
        if (pickupDate == null || dropoffDate == null || dropoffDate.isBefore(pickupDate)) {
            model.addAttribute("error", "请选择有效的取车和还车日期");
            return "rent";
        }

        // 计算租赁天数和总价
        long rentalDays = java.time.temporal.ChronoUnit.DAYS.between(pickupDate, dropoffDate) + 1;
        double totalPrice = rentalDays * car.getPricePerDay();

        // 获取当前用户
        String username = authentication.getName();
        User currentUser = userService.findByUsername(username);

        // 创建订单
        Order order = new Order();
        order.setCar(car);
        order.setPickupLocation(rentalLocationService.findById(orderForm.getPickupLocationId()));
        order.setDropoffLocation(rentalLocationService.findById(orderForm.getDropoffLocationId()));
        order.setPickupDate(pickupDate.atStartOfDay());
        order.setDropoffDate(dropoffDate.atStartOfDay());
        order.setRentalDays((int) rentalDays);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(LocalDateTime.now());
        order.setUser(currentUser);
        order.setStatus("UNPAID");
        order.setTotalCost(totalPrice);
        orderService.save(order);

        // 将车辆设置为不可用
        car.setAvailable(false);
        carService.save(car);

        // 重定向到支付页面
        return "redirect:/payment?orderId=" + order.getId();
    }
}