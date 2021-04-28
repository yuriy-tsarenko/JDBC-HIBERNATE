package com.cbs.jdbc_hibernate.exapmles.lesson2.app;

import com.cbs.jdbc_hibernate.exapmles.lesson2.app.entity.Customer;
import com.cbs.jdbc_hibernate.exapmles.lesson2.app.service.CustomerService;
import com.cbs.jdbc_hibernate.exapmles.lesson2.app.service.CustomerServiceImpl;

import java.util.Map;

public class EmployeeApp {

    private static final  CustomerService customerService = new CustomerServiceImpl();

    public static void main(String[] args) {

        Customer customerById = customerService.getCustomerById(11);
        System.out.println(customerById);

        customerService.updateCustomer(Map.of("customerName", "Kate"), 11);

        customerById = customerService.getCustomerById(11);
        System.out.println(customerById);
    }
}
