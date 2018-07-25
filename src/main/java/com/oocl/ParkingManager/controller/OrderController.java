package com.oocl.ParkingManager.controller;


import com.oocl.ParkingManager.model.Order;
import com.oocl.ParkingManager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("order")
    public Order addOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

}
