package org.example.Designs;

import lombok.Data;

@Data
public class Location {
    private Integer x;
    private Integer y;

    public Integer getDistance( Location loc){
        return Math.abs((this.x - loc.x) + (this.y - loc.y));
    }
    Location(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Location getLocation(){
        return  this;
    }
}
