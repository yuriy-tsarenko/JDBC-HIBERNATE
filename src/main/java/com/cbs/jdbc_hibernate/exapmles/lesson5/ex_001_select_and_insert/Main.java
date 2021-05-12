package com.cbs.jdbc_hibernate.exapmles.lesson5.ex_001_select_and_insert;


import com.cbs.jdbc_hibernate.exapmles.lesson5.ex_001_select_and_insert.entity.Author;

import java.util.List;


public class Main {

 //   private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

//        Author author = new Author("Shevchenko");
//
//        ah.addAuthor(author);

        Author author = ah.getAuthorById(2);

      //  for (Author a : authorList) {
        System.out.println(author.getId() + " " + author.getName());
       // }

    }

}
