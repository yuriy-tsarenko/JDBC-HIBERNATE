package com.cbs.jdbc_hibernate.cherednichenko.lesson_1.task_1;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Задание 2
//        Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
//        1) Получите контактные данные сотрудников (номера телефонов, место жительства).
//        2) Получите всю информацию о сотрудниках и их номера.
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    private static final String BASE_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_NAME = "employee_db";
    private static final String TIMEZONE = "UTC";
    private static final String USE_LEGACY_DT_CODE = "false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        String data = "SELECT firstName,lastName,extension,email,jobTitle,phone,city,addressLine1,addressLine2 "
                + "FROM employees "
                + "LEFT JOIN offices o ON employees.officeCode = o.officeCode"
                + " ORDER BY firstName;";
        try (Connection connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(data)) {

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String extension = resultSet.getString("extension");
                String email = resultSet.getString("email");
                String jobTitle = resultSet.getString("jobTitle");
                String phone = resultSet.getString("phone");
                String city = resultSet.getString("city");
                String addressLineOne = resultSet.getString("addressLine1");
                String addressLineTwo = resultSet.getString("addressLine2");
                System.out.println(firstName + "\t" + firstName + "\t" + lastName + "\t" + extension + "\t" + email
                        + "\t" + jobTitle + "\t" + phone + "\t" + city + "\t" + addressLineOne + "\t" + addressLineTwo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}

