package com.cbs.jdbc_hibernate.homework.jdbc_lesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {

    static Connection getDbConect() {
        String dbHost = "localhost:";
        String dbPort = "3306";
        String dbName = "/employee_db";
        String dbUser = "root";
        String dbPass = "h78d24v01";
        String queryConect = "jdbc:mysql://" + dbHost + dbPort + dbName + "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("successful install driver..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("not instal driver");
        }
        try {
            return DriverManager.getConnection(queryConect, dbUser, dbPass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
