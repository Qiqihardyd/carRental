package com.example.rentalsystem.controller;

import com.example.rentalsystem.model.Order;
import com.example.rentalsystem.model.User;
import com.example.rentalsystem.service.OrderService;
import com.example.rentalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    // 显示支付页面
    @GetMapping
    public String showPaymentPage(@RequestParam("orderId") Long orderId, Authentication authentication, Model model) {
        // 获取订单信息
        Order order = orderService.findById(orderId);

        if (order == null) {
            model.addAttribute("error", "订单不存在");
            return "error";
        }

        // 获取当前用户
        String username = authentication.getName();
        User currentUser = userService.findByUsername(username);

        // 检查订单是否属于当前用户
        if (!order.getUser().getId().equals(currentUser.getId())) {
            model.addAttribute("error", "您无权查看此订单");
            return "error";
        }

        model.addAttribute("order", order);
        return "payment";
    }

    // 处理支付请求
    @PostMapping
    public String processPayment(@RequestParam("orderId") Long orderId, Authentication authentication, Model model) {
        // 获取订单信息
        Order order = orderService.findById(orderId);

        if (order == null) {
            model.addAttribute("error", "订单不存在");
            return "error";
        }

        // 获取当前用户
        String username = authentication.getName();
        User currentUser = userService.findByUsername(username);

        // 检查订单是否属于当前用户
        if (!order.getUser().getId().equals(currentUser.getId())) {
            model.addAttribute("error", "您无权支付此订单");
            return "error";
        }

        // 模拟支付处理
        order.setStatus("PAID");
        orderService.save(order);

        model.addAttribute("message", "支付成功");
        return "paymentSuccess";
    }
}