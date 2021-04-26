package com.cbs.jdbc_hibernate.exapmles.ex004_prepared_statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carsshop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish(title, description, rating, published, created, icon) "
            + " VALUES(?,?,?,?,?,?)";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW)) {

            statement.setString(1, "Title");
            statement.setString(2, "Description");
            statement.setDouble(3, 4.5);
            statement.setBoolean(4, false);
            statement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
            statement.setBlob(6, new FileInputStream("chair.png"));

            statement.execute();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
