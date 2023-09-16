package com.college.sportik.feature.user.dto;

public class UserDTOReceive {

    String username;
    String password;

    public UserDTOReceive(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
