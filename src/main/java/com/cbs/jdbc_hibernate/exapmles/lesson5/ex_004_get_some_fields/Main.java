package com.cbs.jdbc_hibernate.exapmles.lesson5.ex_004_get_some_fields;


import com.cbs.jdbc_hibernate.exapmles.lesson5.ex_004_get_some_fields.entity.Author;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

        List<Author> authors = ah.getAuthorList();

        for (Author author : authors) {
            System.out.println(author.getId() + " " + author.getName() + " " + author.getLastName());
        }

    }

}
