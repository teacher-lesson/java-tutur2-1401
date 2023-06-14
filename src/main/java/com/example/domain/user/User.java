package com.example.domain.user;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private long registerDate;
    private long lastLoginDate;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
