package com.oocl.ParkingManager.controller;

import com.oocl.ParkingManager.model.ParkingBoy;
import com.oocl.ParkingManager.model.ParkingLot;
import com.oocl.ParkingManager.service.ParkingBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingBoyController {
    @Autowired
    ParkingBoyService parkingBoyService;
    @PostMapping(path="/ParkingBoys")
    public boolean addParkingBoy(@RequestBody ParkingBoy parkingBoy)
    {
        return  parkingBoyService.addParkingBoy(parkingBoy);
    }
    @GetMapping(path="/ParkingBoys")
    public List<ParkingBoy> getAllParkingBoys (){
        return parkingBoyService.getAllParkingBoys();
    }
    @PutMapping(path="/ParkingBoys/{PBId}")
    public List<ParkingLot> assignParkingLot(@RequestBody ParkingLot parkingLot, @PathVariable Long PBId)
    {
          return parkingBoyService.assignParkingLot(PBId,parkingLot);
    }
}
