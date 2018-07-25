package com.oocl.ParkingManager.service;

import com.oocl.ParkingManager.exception.OrderIsNotExistException;
import com.oocl.ParkingManager.exception.ParkFailException;
import com.oocl.ParkingManager.model.Order;
import com.oocl.ParkingManager.model.ParkingBoy;
import com.oocl.ParkingManager.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingBoyService {
    Map<Long, ParkingBoy> parkingBoys = new HashMap<>();
@Autowired
    ParkingLotService parkingLotService;
@Autowired OrderService orderService;
    public List<ParkingLot> assignParkingLot(Long pbId, ParkingLot parkingLot) {
        return parkingLotService.assginToParkingBoy(pbId,parkingLot);
    }

    public boolean addParkingBoy(ParkingBoy parkingBoy) {
        if (parkingBoys.put(parkingBoy.getId(), parkingBoy) == null)
            return true;
        return false;
    }

    public List<ParkingBoy> getAllParkingBoys() {
        return converMapToList(parkingBoys);
    }
    private  List<ParkingBoy> converMapToList(Map<Long,ParkingBoy>map) {
        List<ParkingBoy> employeesList = new ArrayList<>();
        for (Long key : map.keySet()) {
            employeesList.add (map.get(key));
        }
        return employeesList;
    }

    public Order park(String orderId, ParkingBoy parkingBoy) throws ParkFailException, OrderIsNotExistException {
        ParkingLot parkingLot = parkingLotService.tryToPark(parkingBoy.getId());
        orderService.updateOrder(orderId, parkingLot.getId());

        return orderService.getOrderById(orderId);

    }
}
