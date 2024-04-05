package org.example.bot;

import org.example.bot.db.DbProps;

import java.sql.*;

public class TestDatabaseInsertion {

    public static void main(String[] args) throws Exception {
        select();

    }

    private static void insert() {
        String url = DbProps.get("db.url");
        String username = DbProps.get("db.username");
        String password = DbProps.get("db.password");

        String query = "INSERT INTO users (id, username, firstname, lastname, phonenumber) " +
                "VALUES ('123124124', 'azamov_23', 'Muhammadiso', 'Azamov', '+998938220038')";


        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            statement.executeUpdate(query);

            statement.close();
            connection.close();

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void select() {
        String urlSQL = DbProps.get("db.url");
        String usernameSQL = DbProps.get("db.username");
        String passwordSQL = DbProps.get("db.password");
        String query = "SELECT * FROM users";

        try (Connection connection = DriverManager.getConnection(urlSQL, usernameSQL, passwordSQL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                long userId = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String phoneNumber = resultSet.getString("phonenumber");

                System.out.println("User ID: " + userId + ", Username: " + username +
                        ", First Name: " + firstName + ", Last Name: " +
                        lastName + ", Phone Number: " + phoneNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error executing select query: " + e.getMessage());
        }
    }

}
