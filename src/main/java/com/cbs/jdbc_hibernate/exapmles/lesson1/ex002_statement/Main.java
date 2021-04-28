package com.cbs.jdbc_hibernate.exapmles.lesson1.ex002_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_db"
            + "?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "ваш пароль?";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("insert into"
                    + " customers(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,"
                    + "addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit)"
                    + "values (10, 'JOHN', 'TEST', 'Carine ', '40.32.2555', '54, rue Royale', NULL, 'Nantes', NULL,"
                    + " '44000', 'France', 1370, '21000.00')");

            int res = statement.executeUpdate("UPDATE customers SET customerName = 'David' WHERE customerNumber=3");
            System.out.println(res);

//            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (3, 'Priora', 4000)");
//            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (2, 'cayman', 14000)");
//            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (1, 'S7', 100000)");

//            statement.executeBatch();

            boolean closed = statement.isClosed();
            System.out.println(closed);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
