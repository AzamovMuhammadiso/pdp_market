package org.example.bot.services;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    // Map to store user preferences
    private Map<Long, String> userPreferences;

    public UserService() {
        // Initialize the map
        userPreferences = new HashMap<>();
    }

    // Method to set user preferences
    public void setUserPreference(Long userId, String preference) {
        userPreferences.put(userId, preference);
    }

    // Method to get user preferences
    public String getUserPreference(Long userId) {
        return userPreferences.get(userId);
    }

}
