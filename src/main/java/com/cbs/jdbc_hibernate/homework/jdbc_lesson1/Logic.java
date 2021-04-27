package com.cbs.jdbc_hibernate.homework.jdbc_lesson1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Logic {
    //customerName,  phone,  city, country
    ResultSet resultSet;
   public void getContactEmploee(){
       try {
            resultSet = DBHandler.getDbConect().createStatement().executeQuery(
                   "SELECT  * FROM employee_db.customers ");
           while (resultSet.next()){
               System.out.println("+---------------------------------------------------------------------+");
               System.out.print("| "+resultSet.getString("customerName")+" | ");
               System.out.print(resultSet.getString("phone")+" | ");
               System.out.print(resultSet.getString("city")+" | ");
               System.out.print(resultSet.getString("country")+" | \n");
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
}
