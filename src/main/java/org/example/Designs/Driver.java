package org.example.Designs;

import lombok.Data;

@Data
public class Driver {
    private String name;
    private String driverId;
    private String phoneNumber;
    private String vehicleNumber;
    private String vehicleModel;
    private  Location location;
    private  boolean isAvailable = true;

    private  Integer totalEarnings =0;



    public Driver(String name, String driverId, String phoneNumber, String vehicleNUmber, String vehicleModel, Location location) {
    this.driverId = driverId;
    this.location = location;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.vehicleModel = vehicleModel;
    this.vehicleNumber =  vehicleNUmber;
    }

    // observer design pattern

    // we can check on destination by taking consideration of total distance from driver to source to destination

    boolean acceptRide(Location source){
        if(this.isAvailable == true){
            Integer distanceFromMe = location.getDistance(source);
            if(distanceFromMe <= 5)return true;
        }
        return false;
    }
}
