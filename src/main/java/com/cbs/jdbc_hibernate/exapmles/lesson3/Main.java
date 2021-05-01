package com.cbs.jdbc_hibernate.exapmles.lesson3;


import com.cbs.jdbc_hibernate.exapmles.lesson3.entity.Customer;
import com.cbs.jdbc_hibernate.exapmles.lesson3.service.CustomerService;

import java.util.List;

public class Main {
    private static final CustomerService customerService = new CustomerService();

    public static void main(String[] args) {

        List<Customer> all = customerService.getAll();
        all.forEach(System.out::println);
        System.out.println();
        Customer customer = customerService.getById(129);
        System.out.println("by id:" + customer);

        Customer customer1 = new Customer(13, "JOHN",
                "null", "null", "null", "null", "null",
                "null", "null", "null", "null", 12, null,
                "null");
        customerService.create(customer1);

        Customer customer3 = customerService.getById(129);
        System.out.println("created" + customer3);

        customerService.delete(customer3);
        Customer customer4 = customerService.getById(129);
        System.out.println("created" + customer4);
    }
}
