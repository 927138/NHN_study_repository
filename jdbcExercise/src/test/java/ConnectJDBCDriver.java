import com.yh.jdbcexercise.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Slf4j
public class ConnectJDBCDriver {

     private static Connection connection = null;

     @BeforeAll
     static void setUp(){
          log.info("connection open()");
          connection = DBUtils.getConnection();
     }

     @AfterAll
     static void release(){
          log.info("connection close()");
          try {
               connection.close();
          } catch (SQLException e){
               throw new RuntimeException(e);
          }
     }

     @Test
     @DisplayName("connected")
     void connectTest(){
          Assertions.assertNotNull(connection);
     }

     @Test
     @DisplayName("mariadb driver load : fail")
     void mariaDB_driverLoadTest(){
          Assertions.assertThrows(ClassNotFoundException.class,
                  ()->Class.forName("org.mariadb.jdbc.Driver"));
     }

     @Test
     @DisplayName("mysql driver load : success")
     void mysql_dirverLoadTest(){
          try{
               Class<?> driver = Class.forName("com.mysql.cj.jdbc.Driver");
               log.info("driver : " + driver.getName());

               Assertions.assertEquals(driver.getName(), com.mysql.cj.jdbc.Driver.class.getName());
          }catch (ClassNotFoundException e){
               log.error("mysql driver load : fail");
          }
     }
}
