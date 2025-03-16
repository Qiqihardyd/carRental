package com.example.rentalsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.example.rentalsystem.model.User;

@Component
public class AdminAccountInitializer {

    @Autowired
    private UserService userService;

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        if (userService.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin123"); // 设置初始密码
            admin.setEmail("admin@example.com");
            admin.setRole("ADMIN");
            userService.registerAdmin(admin);
            System.out.println("Admin account created.");
        }
    }
}
