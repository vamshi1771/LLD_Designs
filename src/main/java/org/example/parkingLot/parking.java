package org.example.parkingLot;

import java.util.Arrays;
import java.util.List;

public class parking {

    public static void main(String[] args){

       ParkingLot parkingLot1 = new ParkingLot();
       ParkingSpace p1 = new ParkingSpace("S1","Car");
       ParkingSpace p2 = new ParkingSpace("s2","bike");
        ParkingSpace p3 = new ParkingSpace("s3","lorry");

        List<ParkingSpace> spaces = Arrays.asList(p1,p2,p3);
        parkingLot1.addParkingSpace(p1);
        parkingLot1.addParkingSpace(p2);
        parkingLot1.addParkingSpace(p3);
        Vehicle v1 = new Vehicle("Car_1","car");
        Vehicle v2 = new Vehicle("Bike_1","bike");

        parkingLot1.parkVehicle(v1);
        parkingLot1.parkVehicle(v2);

        parkingLot1.vacateVehicle(v1);



    }
}
