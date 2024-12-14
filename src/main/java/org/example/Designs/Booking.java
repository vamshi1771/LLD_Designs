package org.example.Designs;

import lombok.Data;

@Data
public class Booking {
   private User user;
    private  Location source;
    private  Location destination;
    private boolean isDriverFound = false;
    private boolean isRideCompleted = false;

    public Integer getDistance(){
        return source.getDistance(destination);
    }

    public Booking(User user, Location source, Location destination){
        this.user =user;
        this.destination = destination;
        this.source = source;
    }


}
