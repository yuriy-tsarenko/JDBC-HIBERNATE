package com.cbs.jdbc_hibernate.exapmles.lesson2.simple_dao.dao;

public interface IdaoFactory {

    CarDao getCarDao();

    ClientDAo getClientDao();


}
