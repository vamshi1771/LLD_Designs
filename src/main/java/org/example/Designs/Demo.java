package org.example.Designs;

import java.util.List;
import java.util.Scanner;

public class Demo {
    public  static  void main(String[] args){
        CabBookingSystem bookingSystem = CabBookingSystem.getInstance();

        // add users

        bookingSystem.add_user("Krishna","1234567890","vamshi@gmail.com", new Location(1,2));
        bookingSystem.add_user("Radha","1234567890","vamshi@gmail.com", new Location(3,2));
        bookingSystem.add_user("Akhil","1234567890","vamshi@gmail.com", new Location(6,4));
        bookingSystem.add_user("Karthik","1234567890","vamshi@gmail.com", new Location(7,3));


        // add Drivers
        bookingSystem.add_driver("Yudhishthira","Id1","-0987654321","Ap-2342","SWIFT",new Location(3,2));
        bookingSystem.add_driver("Bhima","Id2","-0987654321","Ap-2342","SWIFT",new Location(4,1));
        bookingSystem.add_driver("Arjuna","Id3","-0987654321","Ap-2342","SWIFT",new Location(9,8));
        bookingSystem.add_driver("Nakula","Id4","-0987654321","Ap-2342","SWIFT",new Location(5,3));
        bookingSystem.add_driver("Sahadeva","Id5","-0987654321","Ap-2342","SWIFT",new Location(7,1));


        System.out.println("Enter your Name to book a ride");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        List<Driver> driverList = bookingSystem.find_driver(userName,new Location(1,2), new Location(5,8));

        for(Driver driver : driverList){
            System.out.println("driver =>" + driver.getName() + "userId->" + driver.getDriverId());
        }
        System.out.println("Use userId for selecting ride");


        System.out.println("choose one Driver for Ride");
        String driverId = sc.nextLine();

        bookingSystem.choose_ride(userName,driverId);

        Integer costForRide = bookingSystem.calculateTotalEarnings(driverId);
        System.out.println("cost for your Ride" + costForRide);


        System.out.println("totalEarnings of" + driverId + "is" + bookingSystem.calculateTotalEarnings(driverId));




    }
}
