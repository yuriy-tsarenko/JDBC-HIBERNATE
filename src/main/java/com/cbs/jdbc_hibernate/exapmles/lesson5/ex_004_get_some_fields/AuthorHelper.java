package com.cbs.jdbc_hibernate.exapmles.lesson5.ex_004_get_some_fields;


import com.cbs.jdbc_hibernate.exapmles.lesson5.ex_004_get_some_fields.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;


public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @SuppressWarnings("unchecked")
    public List<Author> getAuthorList() {
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();


        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        // не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery<Author> builderQuery = criteriaBuilder.createQuery(Author.class);

        Root<Author> root = builderQuery.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        Selection[] selections = {root.get("id")};

        builderQuery.select(criteriaBuilder.construct(Author.class, selections));
        // необязательный оператор, если просто нужно получить все значения

        //этап выполнения запроса
        Query query = session.createQuery(builderQuery);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id); // получение объекта по id
        session.close();
        return author;
    }

    public Author addAuthor(Author author) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(author); // сгенерит ID и вставит в объект

        session.getTransaction().commit();

        session.close();


        return author;

    }

}
