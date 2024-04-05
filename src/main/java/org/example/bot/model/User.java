package org.example.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    @JsonProperty("id")
    private long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("phonenumber")
    private String phoneNumber;
    @JsonProperty("location")
    private String location;
}
