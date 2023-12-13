import com.yh.jdbcexercise.pool.BasicConnectionpool;
import java.sql.Connection;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@Slf4j
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class BasicConnectionPoolTest {

     static BasicConnectionpool basicConnectionPool;
     static Connection connection1;
     static Connection connection2;
     static Connection connection3;
     static Connection connection4;
     static Connection connection5;

     @BeforeAll
     static void setUp() {
          String url = "jdbc:mysql://133.186.241.167:3306/nhn_academy_48";
          String user = "nhn_academy_48";
          String pw = "/q-b(E(D7s_lI8@c";

          basicConnectionPool = new BasicConnectionpool(com.mysql.cj.jdbc.Driver.class.getName(),url, user, pw, 5);
     }

     @AfterAll
     static void connectionClose() throws SQLException {
          basicConnectionPool.distory();
     }

     @Test
     @Order(0)
     @DisplayName("Driver not found Exception")
     void init(){
          Assertions.assertThrows(RuntimeException.class,
                  ()-> new BasicConnectionpool("org.mariadb.jdbc.Driver","jdbcUrl","userName","password",5)
          );
     }

     @Test
     @Order(1)
     @DisplayName("get connection")
     void getConnection() throws InterruptedException, SQLException {
          connection1 = basicConnectionPool.getConnection();
          log.debug("connect1");
          connection2 = basicConnectionPool.getConnection();
          log.debug("connect2");
          connection3 = basicConnectionPool.getConnection();
          log.debug("connect3");
          Assertions.assertAll(
                  ()->Assertions.assertTrue(connection1.isValid(1000)),
                  ()->Assertions.assertTrue(connection2.isValid(1000)),
                  ()->Assertions.assertTrue(connection3.isValid(1000)),
                  ()->Assertions.assertEquals(basicConnectionPool.getUsedConnectionSize(),3)
          );
     }

     @Disabled
     @Test
     @Order(2)
     @DisplayName("empty connection-pool")
     void getConnection_empty() throws InterruptedException, SQLException {
          connection4 = basicConnectionPool.getConnection();
          connection5 = basicConnectionPool.getConnection();
          Connection connection6 = basicConnectionPool.getConnection();

          Assertions.assertAll(
                  ()->Assertions.assertEquals(basicConnectionPool.getUsedConnectionSize(),5)
          );

     }

     @Test
     @Order(3)
     @DisplayName("release connection")
     void releaseConnection() {
          basicConnectionPool.releaseConnection(connection1);
          basicConnectionPool.releaseConnection(connection2);
          basicConnectionPool.releaseConnection(connection3);

          Assertions.assertEquals(basicConnectionPool.getUsedConnectionSize(),0);
     }
}