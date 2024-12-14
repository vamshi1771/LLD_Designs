package org.example.parkingLot;

import lombok.Data;

@Data
public class  ParkingSpace {
    private String spaceId;
    private String spaceType;
    private  Vehicle vehicle;
    private boolean isOccupied = false;

    ParkingSpace(String spaceId , String spaceType){
        this.spaceId = spaceId;
        this.spaceType = spaceType;
    }

    void fillSpace(Vehicle vehicle){
        if(!vehicle.getVehicleType().toLowerCase().equals(spaceType.toLowerCase())){
            System.out.println("You can't park here");
        }
        else {
            isOccupied = true;
            this.vehicle = vehicle;
        }
    }

    void removeSpace(){
        isOccupied = false;
        this.vehicle = null;
    }
}
