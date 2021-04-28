package com.cbs.jdbc_hibernate.exapmles.lesson1.ex006_delete_from_dish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carsshop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String DELETE = "DELETE FROM dish WHERE id = ? AND title = ?";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setString(2, "Title");
            statement.setInt(1, 2);

            int res = statement.executeUpdate();
            System.out.println(res);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
