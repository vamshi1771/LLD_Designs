package org.example.design1;

import lombok.Data;

@Data
public class Users {
    private String user;
    private String email;
    private String userId;
    private String phoneNumber;
    public Users(String user, String email, String userId, String phoneNumber){
        this.email = email;
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }
}
