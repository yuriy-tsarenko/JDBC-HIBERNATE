package com.cbs.jdbc_hibernate.exapmles.lesson5.ex_003_generated_id;


import com.cbs.jdbc_hibernate.exapmles.lesson5.ex_003_generated_id.entity.Author;

public class Main {

 //   private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
         AuthorHelper ah = new AuthorHelper();
         Author author = new Author("Taras");

         ah.addAuthor(author);
    }

}
