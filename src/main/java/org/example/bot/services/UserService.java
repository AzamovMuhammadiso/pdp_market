package org.example.bot.services;

import org.example.bot.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<Long, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public void saveUser(Long userId, String firstName, String lastName, String phoneNumber, String username) {
        User newUser = new User();
        newUser.setId(userId);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setUsername(username);
        users.put(userId, newUser);
    }

    public boolean isUserExists(Long userId) {
        return users.containsKey(userId);
    }

    public User getUser(Long userId) {
        return users.get(userId);
    }

}
