package com.cbs.jdbc_hibernate.exapmles.lesson2.simple_dao.dao;

public class DaoFactory implements IdaoFactory {

    private static IdaoFactory factory;

    private DaoFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized IdaoFactory getInstance() {
        if (factory == null) {
            factory = new DaoFactory();
        }
        return factory;
    }

    @Override
    public CarDao getCarDao() {
        return new CarJdbcDao();
    }

    @Override
    public ClientDAo getClientDao() {
        return null;
    }

}
