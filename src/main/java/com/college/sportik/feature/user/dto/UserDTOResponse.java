package com.college.sportik.feature.user.dto;

public class UserDTOResponse {

    Integer id;
    String username;
    String firstName;
    String lastName;
    String role;
    String password;

    public UserDTOResponse(Integer id, String username, String firstName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
