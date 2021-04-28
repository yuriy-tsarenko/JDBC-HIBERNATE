package com.cbs.jdbc_hibernate.exapmles.lesson1.ex005_get_all_from_dish;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carsshop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String GET_ALL = "SELECT * FROM dish";

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(GET_ALL);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
               int id = resultSet.getInt("id");
               String title = resultSet.getString("title");
               String description = resultSet.getString("description");
               double rating = resultSet.getDouble("rating");
               boolean published = resultSet.getBoolean("published");
               Date date = resultSet.getDate("created");
               byte[] bytes = resultSet.getBytes("icon");

                System.out.println(id + " " + " " + title + " " + description
                                  + " " + rating + " " + published + " " + date
                                   );

//                for (int i = 0; i < bytes.length; i++) {
//                    System.out.println(bytes[i]);
//                }
            }

        } catch (SQLException  e) {
            e.printStackTrace();
        }  finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
