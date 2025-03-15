package com.example.rentalsystem.controller;

import com.example.rentalsystem.model.User;
import com.example.rentalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 显示注册页面
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // 处理注册表单提交
    @PostMapping("/register")
    public String register(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        // 检查用户名是否已存在
        if (userService.findByUsername(user.getUsername()) != null) {
            redirectAttributes.addFlashAttribute("error", "用户名已存在");
            return "redirect:/register";
        }
        userService.register(user);
        redirectAttributes.addFlashAttribute("success", "注册成功，请登录");
        return "redirect:/login";
    }

    // 显示登录页面
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // 添加主页映射
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/login")
    public String loginSuccess() {
        // 重定向到 /home
        return "redirect:/home";
    }
}