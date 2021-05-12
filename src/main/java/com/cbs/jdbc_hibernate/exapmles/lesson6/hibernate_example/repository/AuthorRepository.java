package com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.repository;

import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.Main;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.util.SessionUtil;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.entity.Author;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorRepository {
    SessionUtil sessionUtil = new SessionUtil();

    public Author getAuthorById(Long id) {
        Session session = sessionUtil.getSession();
        Author author = session.get(Author.class, id);
        sessionUtil.close();
        return author;
    }

    public Author getAuthorWithBooks(Long id) {
        Session session = sessionUtil.getSession();
        Author author = session.get(Author.class, id);
        //lazy loading
        List<Book> books = author.getBooks();
        Main.print(books.get(0), Book.class);
        sessionUtil.close();
        return author;
    }

    public List<Author> getAllByName(String name) {
        Session session = sessionUtil.getSession();
        Query<Author> query = session.createQuery("from Author where name= :name", Author.class);
        query.setParameter("name", name);
        List<Author> resultList = query.getResultList();
        sessionUtil.close();
        return resultList;
    }

    public List<Author> getAll() {
        Session session = sessionUtil.getSession();
        Query<Author> query = session.createQuery("from Author", Author.class);
        List<Author> resultList = query.getResultList();
        sessionUtil.close();
        return resultList;
    }

    public void deleteById(Long id) {
        Author authorById = getAuthorById(id);
        Session session = sessionUtil.getSession();
        session.delete(authorById);
        sessionUtil.close();
    }
}
