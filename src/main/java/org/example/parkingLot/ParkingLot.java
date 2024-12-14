package org.example.parkingLot;

import java.util.ArrayList;
import java.util.List;

// singleton class
public class ParkingLot {
//    private static ParkingLot instance;
    private String parkingLotId;
    private Integer totalSpace;
    private Integer availableSpace;
    private List<ParkingSpace> spaces = new ArrayList<>();


//    public ParkingLot getInstance(){
//        if(instance == null){
//            synchronized (ParkingLot.class){
//                if(instance == null){
//                    return new ParkingLot();
//                }
//            }
//        }
//        return  instance;
//    }

    void parkVehicle(Vehicle vehicle){
        for (int i=0;i<spaces.size();i++){
            ParkingSpace space = spaces.get(i);
            if(!space.isOccupied() && space.getSpaceType().toLowerCase().equals(vehicle.getVehicleType().toLowerCase())){
                space.fillSpace(vehicle);
                System.out.println(vehicle.getVehicleId() + " is parked at " + space.getSpaceId());
            }
        }
    }
    void vacateVehicle(Vehicle vehicle){

        for (int i=0;i<spaces.size();i++){
            ParkingSpace space = spaces.get(i);
            if(space.getVehicle().getVehicleId().equals(vehicle.getVehicleId())){
                space.removeSpace();
                System.out.println(space.getSpaceId() + " is vacated");
            }
        }
    }
    void addParkingSpace(ParkingSpace space){
        if(space == null) return;
        spaces.add(space);
    }
    void removeParkingSpace(ParkingSpace space){
        spaces.remove(space);
    }


}
