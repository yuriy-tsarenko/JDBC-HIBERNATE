package com.cbs.jdbc_hibernate.exapmles.lesson3.service;

import com.cbs.jdbc_hibernate.exapmles.lesson3.entity.Employee;
import com.cbs.jdbc_hibernate.exapmles.lesson3.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeService {

    private final SessionUtil sessionUtil = new SessionUtil();

    public Employee getById(Integer id) {
        Session session = sessionUtil.getSession();
        Employee employee = session.get(Employee.class, id);
        sessionUtil.close();
        return employee;
    }

    public List<Employee> getAll() {
        Session session = sessionUtil.getSession();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        CriteriaQuery<Employee> select = query.select(root);
        TypedQuery<Employee> all = session.createQuery(select);
        sessionUtil.close();
        return all.getResultList();
    }

    public void update(Employee employee) {
        Session session = sessionUtil.getSession();
        session.update(employee);
        sessionUtil.close();
    }

    public void deleteById(Integer id) {
        Session session = sessionUtil.getSession();
        session.delete(id);
        sessionUtil.close();
    }


    public void create(Employee employee) {
        Session session = sessionUtil.getSession();
        session.save(employee);
        sessionUtil.close();
    }

}
