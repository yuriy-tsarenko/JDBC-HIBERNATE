package com.cbs.jdbc_hibernate.cherednichenko.lesson_1.task_3;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    private static final String BASE_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_NAME = "employee_db";
    private static final String TIMEZONE = "UTC";
    private static final String USE_LEGACY_DT_CODE = "false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    public static String createURL() {
        return BASE_URL
                + "/"
                + DB_NAME
                + "?"
                + "useLegacyDatetimeCode=" + USE_LEGACY_DT_CODE
                + "&"
                + "serverTimezone=" + TIMEZONE;
    }

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            Scanner scanner = new Scanner(new File("src\\main\\java\\com\\cbs\\jdbc_hibernate\\"
                    + "cherednichenko\\lesson_1\\task_3\\Lesson2.sql"));
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                statement.execute(scanner.next());
                System.out.println("Success");
            }
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
