package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository;

import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.db_connector.DataBaseConnector;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity.CustomerEntity;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.util.PrimaryKey;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.util.Constants.CHAR;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final Logger log = Logger.getLogger(CustomerRepositoryImpl.class);

    @Override
    public void createClient(CustomerEntity customerEntity) {

        try {
            DataBaseConnector.createConnection()
                    .execute("insert into"
                            + " customers(customerNumber, customerName, contactLastName, contactFirstName, phone,"
                            + " addressLine1,"
                            + "addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit)"
                            + " values ("
                            + CHAR + customerEntity.getCustomerNumber() + CHAR + ","
                            + CHAR + customerEntity.getCustomerName() + CHAR + ","
                            + CHAR + customerEntity.getContactLastName() + CHAR + ","
                            + CHAR + customerEntity.getContactFirstName() + CHAR + ","
                            + CHAR + customerEntity.getPhone() + CHAR + ","
                            + CHAR + customerEntity.getAddressLineOne() + CHAR + ","
                            + CHAR + customerEntity.getAddressLineTwo() + CHAR + ","
                            + CHAR + customerEntity.getCity() + CHAR + ","
                            + CHAR + customerEntity.getState() + CHAR + ","
                            + CHAR + customerEntity.getPostalCode() + CHAR + ","
                            + CHAR + customerEntity.getCountry() + CHAR + ","
                            + CHAR + customerEntity.getSalesRepEmployeeNumber() + CHAR + ","
                            + CHAR + customerEntity.getCreditLimit() + CHAR
                            + ");");
            DataBaseConnector.closeConnection();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public int updateClient(Map<String, Object> args, Integer customerNumber) {
        PrimaryKey<Integer> primaryKey = new PrimaryKey<>();
        primaryKey.setKey("customerNumber");
        primaryKey.setValue(customerNumber);
        Statement connection = null;
        int update = 0;
        try {
            connection = DataBaseConnector.createConnection();
            update = connection.executeUpdate(queryBuilderUpdate(args, primaryKey, "customers"));
            DataBaseConnector.closeConnection();
        } catch (Exception e) {
            log.error(e);
        }
        return update;
    }

    @Override
    public List<CustomerEntity> getAllClients() {
        return getAllEntities("SELECT * FROM customers", CustomerEntity.class);
    }

    @Override
    public CustomerEntity getClient(Integer customerNumber) {
        return getAllEntities("SELECT * FROM customers WHERE customerNumber=" + CHAR + customerNumber + CHAR + ";",
                CustomerEntity.class).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("client not found"));
    }
}
