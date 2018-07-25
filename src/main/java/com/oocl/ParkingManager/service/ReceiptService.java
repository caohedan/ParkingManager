package com.oocl.ParkingManager.service;

import com.oocl.ParkingManager.model.Receipt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService {
    private List<Receipt> receiptList = new ArrayList<>();

    public Receipt getReceipt() {
        Receipt receipt = new Receipt();
        String uuid = UUID.randomUUID().toString();
        receipt.setId(uuid);
        receiptList.add(receipt);
        return receipt;
    }

    public List<Receipt> () {
        return receiptList;
    }
}
