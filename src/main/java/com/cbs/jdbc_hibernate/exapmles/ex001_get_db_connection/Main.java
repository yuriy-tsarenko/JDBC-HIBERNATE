package com.cbs.jdbc_hibernate.exapmles.ex001_get_db_connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    private static final String BASE_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_NAME = "employee_db";
    private static final String TIMEZONE = "UTC";
    private static final String USE_LEGACY_DT_CODE = "false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "ваш пароль?";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Correct connection to db!");
            }

            connection.close();

            if (connection.isClosed()) {
                System.out.println("Connection closed :(");
            }

        } catch (SQLException e) {
            log.error(e);
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
