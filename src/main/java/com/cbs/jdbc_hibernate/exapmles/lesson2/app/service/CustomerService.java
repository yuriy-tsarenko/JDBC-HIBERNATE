package com.cbs.jdbc_hibernate.exapmles.lesson2.app.service;

import com.cbs.jdbc_hibernate.exapmles.lesson2.app.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer customerNumber);

    int updateCustomer(Map<String, Object> args, Integer customerNumber);

    void createCustomer(Customer customer);
}
