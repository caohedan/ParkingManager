package com.oocl.ParkingManager.model;

public class ParkingLot {
    Long id;
    Long ParkingBoyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParkingBoyId() {
        return ParkingBoyId;
    }

    public void setParkingBoyId(Long parkingBoyId) {
        ParkingBoyId = parkingBoyId;
    }

}
