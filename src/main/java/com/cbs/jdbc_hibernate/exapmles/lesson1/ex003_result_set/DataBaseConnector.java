package com.cbs.jdbc_hibernate.exapmles.lesson1.ex003_result_set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseConnector {

    private static final Logger log = Logger.getLogger(DataBaseConnector.class);

    private static final String BASE_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_NAME = "employee_db";
    private static final String TIMEZONE = "UTC";
    private static final String USE_LEGACY_DT_CODE = "false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Mysql22061993";
    private static final String CHAR = "'";

    public DataBaseConnector() {
    }

    public String createURL() {
        return BASE_URL
                + "/"
                + DB_NAME
                + "?"
                + "useLegacyDatetimeCode=" + USE_LEGACY_DT_CODE
                + "&"
                + "serverTimezone=" + TIMEZONE;
    }

    public void createClient(Integer customerNumber, String customerName, String contactLastName,
                             String contactFirstName, String phone, String addressLineOne, String addressLineTwo,
                             String city, String state, String postalCode, String country,
                             Integer salesRepEmployeeNumber, BigDecimal creditLimit) {

        try (Connection connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("insert into"
                    + " customers(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,"
                    + "addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit)"
                    + "values ("
                    + CHAR + customerNumber + CHAR + ","
                    + CHAR + customerName + CHAR + ","
                    + CHAR + contactLastName + CHAR + ","
                    + CHAR + contactFirstName + CHAR + ","
                    + CHAR + phone + CHAR + ","
                    + CHAR + addressLineOne + CHAR + ","
                    + CHAR + addressLineTwo + CHAR + ","
                    + CHAR + city + CHAR + ","
                    + CHAR + state + CHAR + ","
                    + CHAR + postalCode + CHAR + ","
                    + CHAR + country + CHAR + ","
                    + CHAR + salesRepEmployeeNumber + CHAR + ","
                    + CHAR + creditLimit + CHAR
                    + ")");
        } catch (SQLException e) {
            log.error(e);
        }
    }

    public List<Customer> getAllClients() {
        List<Customer> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            Gson gson = new GsonBuilder().serializeNulls().create();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                Object value;
                String key;
                for (int i = 1; i <= columnCount; i++) {
                    value = resultSet.getObject(i);
                    key = metaData.getColumnLabel(i);
                    row.put(key, value);
                }
                String jsonMap = gson.toJson(row);
                Customer customer = gson.fromJson(jsonMap, Customer.class);
                clients.add(customer);
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return clients;
    }
}
