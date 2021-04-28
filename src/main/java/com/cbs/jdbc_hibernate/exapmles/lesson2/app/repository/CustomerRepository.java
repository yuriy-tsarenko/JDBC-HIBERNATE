package com.cbs.jdbc_hibernate.exapmles.lesson2.app.repository;



import com.cbs.jdbc_hibernate.exapmles.lesson2.app.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerRepository {

    void createClient(Customer customer);

    int updateClient(Map<String, Object> args, Integer customerNumber);

    List<Customer> getAllClients();

    Customer getClient(Integer customerNumber);

}
