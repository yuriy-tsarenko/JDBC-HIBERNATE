package com.cbs.jdbc_hibernate.exapmles.lesson3.service;

import com.cbs.jdbc_hibernate.exapmles.lesson3.entity.Customer;
import com.cbs.jdbc_hibernate.exapmles.lesson3.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerService {

    private final SessionUtil sessionUtil = new SessionUtil();

    public Customer getById(Integer id) {
        Session session = sessionUtil.getSession();
        Customer customer = session.get(Customer.class, id);
        sessionUtil.close();
        return customer;
    }

    public List<Customer> getAll() {
        Session session = sessionUtil.getSession();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        CriteriaQuery<Customer> select = query.select(root);
        TypedQuery<Customer> all = session.createQuery(select);
        List<Customer> resultList = all.getResultList();
        sessionUtil.close();
        return resultList;
    }

    public void update(Customer customer) {
        Session session = sessionUtil.getSession();
        session.update(customer);
        sessionUtil.close();
    }

    public void delete(Customer customer) {
        Session session = sessionUtil.getSession();
        session.delete(customer);
        sessionUtil.close();
    }


    public void create(Customer customer) {
        Session session = sessionUtil.getSession();
        session.save(customer);
        sessionUtil.close();
    }

}
