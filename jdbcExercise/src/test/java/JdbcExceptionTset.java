import com.yh.jdbcexercise.util.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class JdbcExceptionTset {

     @Test
     @DisplayName("query error")
     void test(){

          String query = "insert into example_student values(100, 'test', 'M' 20)";

          try (Connection connection = DBUtils.getConnection()){
               SQLException exception = Assertions.assertThrows(SQLException.class,
                    ()-> {
                         Statement statement = connection.createStatement();
                         statement.execute(query);
                    });

               log.info("errorCode : {}", exception.getErrorCode());
               log.info("message : {}", exception.getMessage());
               log.info("sqlState : ", exception.getSQLState());
          } catch (SQLException e){
               e.getSQLState();

          }

     }
}
