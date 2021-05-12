package com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.repository;

import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.util.SessionUtil;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookRepository {

    SessionUtil sessionUtil = new SessionUtil();

    public Book getBookById(Long id) {
        Session session = sessionUtil.getSession();
        Book book = session.get(Book.class, id);
        sessionUtil.close();
        return book;
    }

    public List<Book> getAllByName(String name) {
        Session session = sessionUtil.getSession();
        Query<Book> query = session.createQuery("from Book where name= :name", Book.class);
        query.setParameter("name", name);
        List<Book> resultList = query.getResultList();
        sessionUtil.close();
        return resultList;
    }

    public List<Book> getAll() {
        Session session = sessionUtil.getSession();
        Query<Book> query = session.createQuery("from Book", Book.class);
        List<Book> resultList = query.getResultList();
        sessionUtil.close();
        return resultList;
    }
}
