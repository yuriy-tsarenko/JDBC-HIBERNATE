package com.cbs.jdbc_hibernate.exapmles.lesson2.simple_dao.dao;


import com.cbs.jdbc_hibernate.exapmles.lesson2.simple_dao.entity.Car;

import java.util.List;

public interface CarDao {

    void add(Car car);

    List<Car> getAll();

    Car getById(int id);

    void updatePrice(int price, int carId);

    void remove(String mark);

}
