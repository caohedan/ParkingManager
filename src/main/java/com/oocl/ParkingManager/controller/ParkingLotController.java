package com.oocl.ParkingManager.controller;

import com.oocl.ParkingManager.model.ParkingLot;
import com.oocl.ParkingManager.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService ;

    @PostMapping(path="/ParkingLots")
    public boolean addParkingLot(@RequestBody ParkingLot parkingLot)
    {
         return parkingLotService.addParkingLot(parkingLot);
    }
    @GetMapping(path="/ParkingLots")
    public List<ParkingLot> getAllParkingLot()
    {
        return parkingLotService.getAllParkingLot();
    }
}
