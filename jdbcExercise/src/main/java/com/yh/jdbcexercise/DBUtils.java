package com.yh.jdbcexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
     private DBUtils(){}

     public static Connection getConnection(){

          String url = "jdbc:mysql://133.186.241.167:3306/nhn_academy_48";
          String user = "nhn_academy_48";
          String pw = "/q-b(E(D7s_lI8@c";

          Connection connection = null;
          try{
               connection = DriverManager.getConnection(url, user, pw);
          }catch (SQLException e){
               throw new RuntimeException(e);
          }

          return connection;
     }
}
