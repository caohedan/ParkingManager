package com.oocl.ParkingManager.controller;


import com.oocl.ParkingManager.model.Order;
import com.oocl.ParkingManager.model.ParkingBoy;
import com.oocl.ParkingManager.service.OrderService;
import com.oocl.ParkingManager.service.ParkingBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ParkingBoyService parkingBoyService;
    @PostMapping(path="Orders/{receiptId}")
    public Order addOrder(@PathVariable String receiptId) throws Exception {
        return orderService.createOrder(receiptId);
    }
    @PutMapping(path="Orders/{orderId}")
    public Order getOrder(@PathVariable String orderId,@RequestBody ParkingBoy parkingBoy) throws Exception {
        return parkingBoyService.park(orderId,parkingBoy);

    }

}
