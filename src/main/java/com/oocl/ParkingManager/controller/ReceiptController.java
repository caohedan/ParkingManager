package com.oocl.ParkingManager.controller;

import com.oocl.ParkingManager.model.Receipt;
import com.oocl.ParkingManager.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @GetMapping(path = "/Receipts")
    public Receipt getReceipt() {
        return receiptService.getReceipt();

    }
}
