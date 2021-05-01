package com.cbs.jdbc_hibernate.exapmles.lesson3.util;

import com.cbs.jdbc_hibernate.exapmles.lesson3.entity.Customer;
import com.cbs.jdbc_hibernate.exapmles.lesson3.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {
    private Transaction transaction;
    private Session session;

    private void init() {
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        configure.addAnnotatedClass(Customer.class);
        configure.addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configure.getProperties())
                .build();

        SessionFactory factory = configure.buildSessionFactory(registry);
        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    public Session getSession() {
        if (session == null && transaction == null) {
            init();
        } else if (session != null && !session.isOpen()) {
            init();
        }
        return session;
    }

    public void close() {
        if (transaction.isActive()) {
            transaction.commit();
        }
        session.close();
    }
}
