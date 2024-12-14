package org.example.parkingLot;

import lombok.Data;

@Data

public class Vehicle {
    private String vehicleId;
    private String vehicleType;
    private Ticket ticket;

    Vehicle(String vehicleId, String vehicleType){
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }
}
