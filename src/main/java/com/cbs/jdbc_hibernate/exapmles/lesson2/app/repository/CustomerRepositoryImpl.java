package com.cbs.jdbc_hibernate.exapmles.lesson2.app.repository;

import com.cbs.jdbc_hibernate.exapmles.lesson2.app.db_connector.DataBaseConnector;
import com.cbs.jdbc_hibernate.exapmles.lesson2.app.entity.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cbs.jdbc_hibernate.exapmles.lesson2.app.util.Constants.CHAR;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final Logger log = Logger.getLogger(CustomerRepositoryImpl.class);


    @Override
    public void createClient(Customer customer) {

        try {
            DataBaseConnector.createConnection()
                    .execute("insert into"
                            + " customers(customerNumber, customerName, contactLastName, contactFirstName, phone,"
                            + " addressLine1,"
                            + "addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit)"
                            + "values ("
                            + CHAR + customer.getCustomerNumber() + CHAR + ","
                            + CHAR + customer.getCustomerName() + CHAR + ","
                            + CHAR + customer.getContactLastName() + CHAR + ","
                            + CHAR + customer.getContactFirstName() + CHAR + ","
                            + CHAR + customer.getPhone() + CHAR + ","
                            + CHAR + customer.getAddressLineOne() + CHAR + ","
                            + CHAR + customer.getAddressLineTwo() + CHAR + ","
                            + CHAR + customer.getCity() + CHAR + ","
                            + CHAR + customer.getState() + CHAR + ","
                            + CHAR + customer.getPostalCode() + CHAR + ","
                            + CHAR + customer.getCountry() + CHAR + ","
                            + CHAR + customer.getSalesRepEmployeeNumber() + CHAR + ","
                            + CHAR + customer.getCreditLimit() + CHAR
                            + ")");
            DataBaseConnector.closeConnection();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    private String queryBuilderUpdate(Map<String, Object> args, Integer customerNumber) throws Exception {
        StringBuilder builder = new StringBuilder("UPDATE customers SET ");
        args.forEach((key, value) -> builder.append(key).append("=").append(CHAR).append(value).append(CHAR));
        if (customerNumber != null) {
            builder.append("WHERE customerNumber=" + CHAR).append(customerNumber).append(CHAR).append(";");
        } else {
            throw new Exception("update without customer number is impossible!");
        }
        return builder.toString();
    }

    @Override
    public int updateClient(Map<String, Object> args, Integer customerNumber) {

        Statement connection = null;
        int update = 0;
        try {
            connection = DataBaseConnector.createConnection();
            update = connection.executeUpdate(queryBuilderUpdate(args, customerNumber));
            DataBaseConnector.closeConnection();
        } catch (Exception e) {
            log.error(e);
        }
        return update;
    }

    @Override
    public List<Customer> getAllClients() {
        return getClients("SELECT * FROM customers");
    }

    @Override
    public Customer getClient(Integer customerNumber) {
        return getClients("SELECT * FROM customers WHERE customerNumber=" + CHAR + customerNumber + CHAR + ";").stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("client not found"));
    }

    private List<Customer> getClients(String query) {
        List<Customer> clients = new ArrayList<>();
        try {
            Statement connection = DataBaseConnector.createConnection();
            Gson gson = new GsonBuilder().serializeNulls().create();
            ResultSet resultSet = connection.executeQuery(query);
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
            DataBaseConnector.closeConnection();
        } catch (SQLException e) {
            log.error(e);
        }
        return clients;
    }
}
