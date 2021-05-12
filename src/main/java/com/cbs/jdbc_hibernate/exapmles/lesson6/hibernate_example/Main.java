package com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example;


import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.entity.Author;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.entity.Book;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.repository.AuthorRepository;
import com.cbs.jdbc_hibernate.exapmles.lesson6.hibernate_example.repository.BookRepository;
import org.apache.log4j.Logger;
import org.hibernate.LazyInitializationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);
    private static final AuthorRepository authorRepository = new AuthorRepository();
    private static final BookRepository bookRepository = new BookRepository();

    public static void main(String[] args) {

        Author authorById = authorRepository.getAuthorById(1L);
        print(authorById, Author.class);
        List<Book> books = authorById.getBooks();
        System.out.println(books);
        List<Author> authorList = authorRepository.getAll();
        authorList.forEach(author -> print(author, Author.class));

        List<Book> bookList = bookRepository.getAll();
        bookList.forEach(book -> print(book, Book.class));

        System.out.println("------------------");

        List<Author> list = authorRepository.getAllByName("John1");
        list.forEach(author -> print(author, Author.class));

        authorRepository.deleteById(1L);

        authorList = authorRepository.getAll();
        authorList.forEach(author -> print(author, Author.class));

        Author authorWithBooks = authorRepository.getAuthorWithBooks(1L);
        print(authorWithBooks, Author.class);
    }

    @SuppressWarnings("unchecked")
    public static <T> void print(Object object, Class<T> type) {
        StringBuilder builder = new StringBuilder();
        T objectType = (T) object;
        Method[] methods = type.getDeclaredMethods();
        for (Method method : methods) {
            try {
                builder.append(method.getName());
                builder.append(": ");
                builder.append(method.invoke(objectType));
                builder.append(" ");
            } catch (IllegalAccessException | InvocationTargetException | LazyInitializationException e) {
                log.error(e);
            }
        }
        builder.append("\n");
        System.out.println(builder);
    }
}
