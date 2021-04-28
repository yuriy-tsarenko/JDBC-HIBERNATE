package com.cbs.jdbc_hibernate.cherednichenko.lesson_1.task_2;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//
//Задание 3
//        Напишите программу которая выполняет все CRUD операции из таблицами employee_db
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    private static final String BASE_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_NAME = "employee_db";
    private static final String TIMEZONE = "UTC";
    private static final String USE_LEGACY_DT_CODE = "false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        String select = "SELECT * "
                + "FROM employees; ";
        String insert = "INSERT INTO employees(employeeNumber, lastName, firstName, extension, "
                + "email, reportsTo, jobTitle, officeCode) "
                + "VALUES (1010, 'Test' ,'Test' ,'Test','Test' ,2 , 'Test', 2);";
        String delete = "DELETE FROM employees WHERE employeeNumber=1010;";
        String update = "UPDATE  employees SET  lastName='ChangedTest' WHERE employeeNumber=1010;";
        insertOrDelete(insert);
        select(select);
        update(update);
        select(select);
        insertOrDelete(delete);
        select(select);
    }

    public static String createURL() {
        return BASE_URL
                + "/"
                + DB_NAME
                + "?"
                + "useLegacyDatetimeCode=" + USE_LEGACY_DT_CODE
                + "&"
                + "serverTimezone=" + TIMEZONE;
    }

    public static void select(String query) {
        try (Connection connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getObject(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertOrDelete(String query) {
        try (Connection connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String query) {
        try (Connection connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate(query);
            System.out.println("Update success: " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
