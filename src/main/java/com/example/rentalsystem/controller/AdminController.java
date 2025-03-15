package com.example.rentalsystem.controller;

import com.example.rentalsystem.model.Car;
import com.example.rentalsystem.model.RentalLocation;
import com.example.rentalsystem.service.CarService;
import com.example.rentalsystem.service.RentalLocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CarService carService;

    @Autowired
    private RentalLocationService rentalLocationService;

    // 显示管理员主页
    @GetMapping
    public String adminHome() {
        return "admin/home";
    }

    // 显示添加车辆信息的表单
    @GetMapping("addCar")
    public String showAddCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "admin/addCar";
    }

    // 处理添加车辆信息的表单提交
    @PostMapping("addCar")
    public String addCar(@Valid @ModelAttribute Car car, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/addCar";
        }

        // 检查车牌号是否已存在
        if (carService.findByLicensePlate(car.getLicensePlate()) != null) {
            result.rejectValue("licensePlate", "error.car", "该车牌号已存在");
            return "admin/addCar";
        }

        carService.save(car);
        redirectAttributes.addFlashAttribute("success", "车辆添加成功");
        return "redirect:/admin";
    }

    // 显示添加租车点信息的表单
    @GetMapping("/addRentalLocation")
    public String showAddRentalLocationForm(Model model) {
        model.addAttribute("rentalLocation", new RentalLocation());
        return "admin/addRentalLocation";
    }

    // 处理添加租车点信息的表单提交
    @PostMapping("/addRentalLocation")
    public String addRentalLocation(@Valid @ModelAttribute RentalLocation rentalLocation, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/addRentalLocation";
        }

        rentalLocationService.save(rentalLocation);
        redirectAttributes.addFlashAttribute("success", "租车点添加成功");
        return "redirect:/admin";
    }

    // 显示车辆列表
    @GetMapping("/cars")
    public String listCars(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "admin/cars";
    }

    // 显示租车点列表
    @GetMapping("/rentalLocations")
    public String listRentalLocations(Model model) {
        List<RentalLocation> rentalLocations = rentalLocationService.findAll();
        model.addAttribute("rentalLocations", rentalLocations);
        return "admin/rentalLocations";
    }

}