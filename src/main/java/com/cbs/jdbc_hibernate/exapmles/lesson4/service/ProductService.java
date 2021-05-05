package com.cbs.jdbc_hibernate.exapmles.lesson4.service;

import com.cbs.jdbc_hibernate.exapmles.lesson4.entity.Product;
import com.cbs.jdbc_hibernate.exapmles.lesson4.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductService {

    private final SessionUtil sessionUtil = new SessionUtil();

    public Product getById(String id) {
        Session session = sessionUtil.getSession();
        Product product = session.get(Product.class, id);
        sessionUtil.close();
        return product;
    }

    //второй вариант как получить все записи таблицы
    public List<Product> getAll() {
        Session session = sessionUtil.getSession();
        List<Product> products = session.createQuery("from Product").list();
        sessionUtil.close();
        return products;
    }

    public void create(Product product) {
        Session session = sessionUtil.getSession();
        session.save(product);
        sessionUtil.close();
    }

    public void update(Product product) {
        Session session = sessionUtil.getSession();
        session.update(product);
        sessionUtil.close();
    }

    public void delete(Product product) {
        Session session = sessionUtil.getSession();
        session.delete(product);
        sessionUtil.close();
    }
}
