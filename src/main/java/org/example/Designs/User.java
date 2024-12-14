package org.example.Designs;

import lombok.Data;

@Data
public class User {
    private String name;

    private String userId;
    private String phoneNumber;
    private String email;
    private Location currLocation;


    public User(String name, String phoneNumber, String email, Location location) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currLocation = location;
    }
}
