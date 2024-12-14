package org.example.Designs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabBookingSystem {
    private static CabBookingSystem instance;
    private Map<String , User> users;
    private Map<String, Driver> drivers;

    private  Map<Booking,Driver> bookings;

    private CabBookingSystem(){
        users = new HashMap<>();
        drivers = new HashMap<>();
        bookings = new HashMap<>();
        System.out.println("Please get the Instance of the class from getInstance method");
    }

    public static CabBookingSystem getInstance(){
        if(instance == null){
            synchronized (CabBookingSystem.class){
                if(instance == null){
                    return instance = new CabBookingSystem();
                }
            }
        }
        return instance;
    }
    void add_user(String name,String phoneNumber, String email, Location location){
        User user = new User(name, phoneNumber,email, location);
        users.put(name, user);
        return;
    }
    void add_driver(String name, String driverId, String phoneNumber, String vehicleNUmber, String vehicleModel, Location location){
        Driver driver = new Driver(name, driverId, phoneNumber,vehicleNUmber,vehicleModel,location);
        drivers.put(driverId,driver);
        return;
    }

    void update_user(String name, Location location){

        User u1 = users.get(name);
        if(u1 == null) {
            System.out.println("No user Found with email");
            return;
        }
        u1.setCurrLocation(location);
        users.put(name,u1);
    }
    void update_driver(String driverId, Location location){
        Driver d1 = drivers.get(driverId);
        if(d1 == null) {
            System.out.println("No driver Found with DriverId");
            return;
        }
        d1.setLocation(location);
        drivers.put(driverId,d1);
        return;
    }

    List<Driver> find_driver(String Name,Location source, Location destination){
        List<Driver> availableDrivers = new ArrayList<>();
        for(Map.Entry<String,Driver> entry : drivers.entrySet()){
            if(entry.getValue().acceptRide(source) == true){
                availableDrivers.add(entry.getValue());
            }
        }
        if(availableDrivers.isEmpty()){
            System.out.println("No Driver are Currently available. Please try after sometime");
        }
        else {
            User user = users.get(Name);
            Booking ride = new Booking(user,source,destination);
            bookings.put(ride,null);
        }
        return availableDrivers;
    }

    void choose_ride(String userName, String driverId){
        Driver d1 = drivers.get(driverId);

        User u1 = users.get(userName);
        Booking booking = null;
        for(Map.Entry<Booking,Driver> entry : bookings.entrySet()){
            Booking b1 = entry.getKey();
            User u = b1.getUser();
            if(u.getName().toLowerCase().equals(userName.toLowerCase())){
                booking = b1;
                break;
            }
        }
        d1.setAvailable(false);
        d1.setTotalEarnings(d1.getTotalEarnings() + booking.getDistance()*10);
        bookings.put(booking,d1);
        return;
    }

    Integer CalculateBill(String userName){
        User u1 = users.get(userName);
        Booking booking = null;
        for(Map.Entry<Booking,Driver> entry : bookings.entrySet()){
            Booking b1 = entry.getKey();
            User u = b1.getUser();
            if(u.getName().toLowerCase().equals(userName.toLowerCase())){
                booking = b1;
                break;
            }
        }
        return booking.getDistance()*10;
    }

    Integer calculateTotalEarnings(String driverId){
        Driver d1 = drivers.get(driverId);
        return d1.getTotalEarnings();
    }


}
