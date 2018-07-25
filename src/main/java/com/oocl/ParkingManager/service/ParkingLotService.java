package com.oocl.ParkingManager.service;

import com.oocl.ParkingManager.exception.ParkFailException;
import com.oocl.ParkingManager.model.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParkingLotService {
   private  Map<Long,ParkingLot> parkingLots = new HashMap<>();
    public boolean addParkingLot(ParkingLot parkingLot) {
        if (parkingLots.put(parkingLot.getId(), parkingLot) == null)
            return true;
        return false;
    }

    public List<ParkingLot> getAllParkingLot() {
        return  converMapToList(parkingLots);
    }

    public Map<Long, ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(Map<Long, ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    private  List<ParkingLot> converMapToList(Map<Long,ParkingLot>map) {
        List<ParkingLot> mapList = new ArrayList<>();
        for (Long key : map.keySet()) {
            mapList.add (map.get(key));
        }
        return mapList;
    }

    public List<ParkingLot> assginToParkingBoy(Long pbId, ParkingLot parkingLot) {
        parkingLot.setParkingBoyId(pbId);
        parkingLots.replace(parkingLot.getId(),parkingLot);
        return converMapToList(parkingLots);
    }

    public ParkingLot tryToPark(Long parkingBoyId) throws ParkFailException {
        List<ParkingLot> parkingLots = converMapToList(getParkingLots()).stream().filter(item -> item.getParkingBoyId() == parkingBoyId && item.getSize() > 0).collect(Collectors.toList());
        if(parkingLots.size()>0){
           ParkingLot parkingLot = parkingLots.get(0);
           parkingLot.setSize(parkingLot.getSize()-1);
            return parkingLot;
        }else{
            throw new ParkFailException();
        }
    }
}
