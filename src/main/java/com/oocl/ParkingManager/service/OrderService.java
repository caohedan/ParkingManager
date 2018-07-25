package com.oocl.ParkingManager.service;

import com.oocl.ParkingManager.model.Order;
import com.oocl.ParkingManager.model.Receipt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    public Order createOrder(Order order) {
            for(i = 0;i<receiptList.size();i++){
                if(receiptList.get(i).getId().equals(ReceiptId)){
                    order.setId(GenerateUtil.genenerateUUID());
                    order.setStatus(false);
                    orderList.add(order);
                    return order;
                }
            }

            throw new Exception("该小票不存在");
        }


}
