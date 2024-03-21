package org.example.bot.services;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<Long, String> userPreferences;

    public UserService() {
        // Initialize the map
        userPreferences = new HashMap<>();
    }

    public void setUserPreference(Long userId, String preference) {
        userPreferences.put(userId, preference);
    }

    public String getUserPreference(Long userId) {
        return userPreferences.get(userId);
    }
}
