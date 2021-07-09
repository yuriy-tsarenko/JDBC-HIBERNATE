package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.service;

import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity.CustomerEntity;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository.CustomerRepository;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository.CustomerRepositoryImpl;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.getAllClients();
    }

    public CustomerEntity getCustomerById(Integer customerNumber) {
        return customerRepository.getClient(customerNumber);
    }

    public int updateCustomer(Map<String, Object> args, Integer customerNumber) {
        return customerRepository.updateClient(args, customerNumber);
    }

    public void createCustomer(CustomerEntity customerEntity) {
        customerRepository.createClient(customerEntity);
    }
}
