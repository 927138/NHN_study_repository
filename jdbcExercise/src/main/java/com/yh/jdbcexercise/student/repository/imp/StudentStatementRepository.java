package com.yh.jdbcexercise.student.repository.imp;

import com.yh.jdbcexercise.DBUtils;
import com.yh.jdbcexercise.student.domain.Student;
import com.yh.jdbcexercise.student.repository.StudentRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StudentStatementRepository implements StudentRepository {

     @Override
     public int save(Student student) {
          String query = String.format("insert into jdbc_students(id,name,gender,age) values('%s','%s','%s',%d)",
                  student.getId(),
                  student.getName(),
                  student.getGender(),
                  student.getAge()
          );
          log.info("query : {}", query);


          try ( Connection connection = DBUtils.getConnection();
               Statement statement = connection.createStatement()){

               int result = statement.executeUpdate(query);
               log.info("save : {}", result);
               return result;
          }catch (SQLException e){
               throw new RuntimeException(e);
          }

     }

     @Override
     public Optional<Student> findById(String id) {
          String query = String.format("select * FROM jdbc_students WHERE id = '%s' ", id);
          log.debug("findById : {}", query);

          try(Connection connection = DBUtils.getConnection();
               Statement statement = connection.createStatement())  {
               ResultSet set = statement.executeQuery(query);

               if(set.next()){
                    Student student =  new Student(
                            set.getString("id"),
                            set.getString("name"),
                            Student.GENDER.valueOf(set.getString("gender")),
                            set.getInt("age"),
                            set.getTimestamp("created_at").toLocalDateTime()
                    );
                    return Optional.of(student);
               }
          } catch (SQLException e){
               throw new RuntimeException(e);
          }

          return Optional.empty();
     }

     @Override
     public int update(Student student) {

          String sql = String.format("update jdbc_students set name='%s', gender='%s', age=%d where id='%s' ",
                  student.getName(),
                  student.getGender(),
                  student.getAge(),
                  student.getId()
          );
          log.debug("update:{}",sql);

          try(Connection connection = DBUtils.getConnection();
              Statement statement = connection.createStatement();
          ) {
               int result = statement.executeUpdate(sql);
               log.debug("result:{}",result);
               return result;
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
     }

     @Override
     public int deleteById(String id) {

          String sql = String.format("delete from jdbc_students where id='%s'",id);

          try(Connection connection = DBUtils.getConnection();
               Statement statement = connection.createStatement()){
               int result = statement.executeUpdate(sql);
               log.debug("result:{}",result);
               return result;
          }catch (SQLException e){
               throw new RuntimeException(e);
          }

     }
}
