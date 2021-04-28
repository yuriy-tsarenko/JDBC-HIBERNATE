package com.cbs.jdbc_hibernate.exapmles.lesson2.app.service;

import com.cbs.jdbc_hibernate.exapmles.lesson2.app.entity.Customer;
import com.cbs.jdbc_hibernate.exapmles.lesson2.app.repository.CustomerRepository;
import com.cbs.jdbc_hibernate.exapmles.lesson2.app.repository.CustomerRepositoryImpl;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllClients();
    }

    public Customer getCustomerById(Integer customerNumber) {
        return customerRepository.getClient(customerNumber);
    }

    public int updateCustomer(Map<String, Object> args, Integer customerNumber) {
        return customerRepository.updateClient(args, customerNumber);
    }

    public void createCustomer(Customer customer) {
        customerRepository.createClient(customer);
    }
}
