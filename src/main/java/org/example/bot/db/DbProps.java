package org.example.bot.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbProps {
    public static String get(String key) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("resources/db.properties"));
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
