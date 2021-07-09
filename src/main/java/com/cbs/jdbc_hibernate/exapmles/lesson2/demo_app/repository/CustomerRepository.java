package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository;



import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

public interface CustomerRepository extends Repository {

    void createClient(CustomerEntity customerEntity);

    int updateClient(Map<String, Object> args, Integer customerNumber);

    List<CustomerEntity> getAllClients();

    CustomerEntity getClient(Integer customerNumber);

}
