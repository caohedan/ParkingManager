package com.oocl.ParkingManager.model;

import org.springframework.stereotype.Component;

@Component
public class ParkingBoy {
    Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
