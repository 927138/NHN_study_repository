package com.yh.jdbcexercise.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;

@Slf4j
public class DBUtils {
     public DBUtils(){
          throw new IllegalStateException("Utility Class");
     }

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

          log.debug("conntion : {}" , connection);
          return connection;
     }

     private static final DataSource DATASOURCE;

     static {
          BasicDataSource basicDataSource = new BasicDataSource();
          basicDataSource.setUrl("jdbc:mysql://133.186.241.167:3306/nhn_academy_48");
          basicDataSource.setUsername("nhn_academy_48");
          basicDataSource.setPassword("/q-b(E(D7s_lI8@c");

          basicDataSource.setInitialSize(5);
          basicDataSource.setMaxTotal(5);
          basicDataSource.setMaxIdle(5);
          basicDataSource.setMinIdle(5);

          basicDataSource.setMaxWait(Duration.ofSeconds(2));
          basicDataSource.setValidationQuery("select 1");
          basicDataSource.setTestOnBorrow(true);
          DATASOURCE = basicDataSource;
     }

     public static DataSource getDataSource(){
          return DATASOURCE;
     }
}
