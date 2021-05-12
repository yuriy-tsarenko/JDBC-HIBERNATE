package com.cbs.jdbc_hibernate.exapmles.lesson5.ex_001_select_and_insert;

import com.cbs.jdbc_hibernate.exapmles.lesson5.ex_001_select_and_insert.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {

    private final SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @SuppressWarnings("unchecked")
    public List<Author> getAuthorList() {
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();
        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery<Author> criteriaQuery = cb.createQuery(Author.class);


        Root<Author> root = criteriaQuery.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        criteriaQuery.select(root);// необязательный оператор, если просто нужно получить все значения


        //этап выполнения запроса
        Query query = session.createQuery(criteriaQuery);

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
