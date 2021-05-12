package com.cbs.jdbc_hibernate.exapmles.lesson6.ex_001_generate_classes.old;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
             factory = new Configuration()
                    .configure("ex_002_configuration.xml")
                    .buildSessionFactory();
        } catch (HibernateException e) {
              e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

}
