package com.oocl.ParkingManager.service;

import com.oocl.ParkingManager.exception.OrderIsNotExistException;
import com.oocl.ParkingManager.exception.ReceiptIsNotExistException;
import com.oocl.ParkingManager.model.Order;
import com.oocl.ParkingManager.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
@Autowired
ReceiptService receiptService;
    private List<Order> orderList = new ArrayList<>();
    public Order createOrder(String receiptId) throws Exception {

                List<Receipt> receiptList = receiptService.getReceiptList();
            for(Receipt r:receiptList){
                if(r.getId().equals(receiptId)){
                    String uuid = UUID.randomUUID().toString();
                    Order order = new Order();
                    order.setReceiptId(receiptId);
                    order.setId(uuid);
                    order.setStatus(false);
                    orderList.add(order);
                    return order;
                }
            }

            throw new ReceiptIsNotExistException();
        }
    public List<Order> getAvaliableOrder() {
        return orderList.stream().filter(item->!item.getStatus()).collect(Collectors.toList());
    }

    public boolean updateOrder(String orderId, Long parkingLotId) throws OrderIsNotExistException {
        List<Order> orders = getAvaliableOrder();
        for(Order o:orders){
            if(o.getId().equals(orderId)){
                o.setStatus(true);
                o.setParkingLotId(parkingLotId);
                return true;
            }
        }
        throw new OrderIsNotExistException();
    }

    public Order getOrderById(String orderId) {
        List<Order> orders = orderList.stream().filter(item->item.getId().equals(orderId)).collect(Collectors.toList());
        if(orders.size()!=0)
            return orders.get(0);
        return null;
    }
}
