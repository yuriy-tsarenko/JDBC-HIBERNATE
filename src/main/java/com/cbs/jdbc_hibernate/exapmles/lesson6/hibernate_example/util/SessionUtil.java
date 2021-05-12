package com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.util;

import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.entity.Author;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.entity.Book;
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
        Configuration configure = new Configuration();
        configure.configure("hibernate_library.cfg.xml");
        configure.addAnnotatedClass(Author.class);
        configure.addAnnotatedClass(Book.class);

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
