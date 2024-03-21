package org.example.bot.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String location;

}
