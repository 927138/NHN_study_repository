package com.yh.jdbcexercise.repository.imp;

import com.yh.jdbcexercise.util.DBUtils;
import com.yh.jdbcexercise.domain.Student;
import com.yh.jdbcexercise.repository.StudentRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StudentPrepareStatementRepository implements StudentRepository {

     @Override
     public int save(Student student) {
          String sql = "insert into jdbc_students(id, name, gender, age) values(?, ?, ?, ?)";

          try (Connection connection = DBUtils.getConnection();
               PreparedStatement statement = connection.prepareStatement(sql)){

               statement.setString(1, student.getId());
               statement.setString(2, student.getName());
               statement.setString(3, student.getGender().toString());
               statement.setInt(4, student.getAge());

               int result = statement.executeUpdate();
               log.info("prepared : {}", result);
               return result;
          }catch (SQLException e){
               throw new RuntimeException(e);
          }
     }

     @Override
     public Optional<Student> findById(String id) {

          String sql = "select * from jdbc_students where id=?";

          ResultSet set = null;
          try (Connection connection = DBUtils.getConnection();
               PreparedStatement statement = connection.prepareStatement(sql)) {

               statement.setString(1, id);

               set = statement.executeQuery();
               if(set.next()){
                    Student student =  new Student(set.getString("id"),
                            set.getString("name"),
                            Student.GENDER.valueOf(set.getString("gender")),
                            set.getInt("age"),
                            set.getTimestamp("created_at").toLocalDateTime()
                    );
                    return Optional.of(student);
               }
          } catch (SQLException e){
               throw new RuntimeException(e);
          } finally {
               try{
                    set.close();
               }catch (SQLException e){
                    throw new RuntimeException(e);
               }
          }

          return Optional.empty();
     }

     @Override
     public int update(Student student) {
          String sql  = "update jdbc_students set name=?, gender=?, age=? where id=?";

          try (Connection connection = DBUtils.getConnection();
               PreparedStatement statement = connection.prepareStatement(sql)){

               statement.setString(1, student.getName());
               statement.setString(2, student.getGender().toString());
               statement.setInt(3, student.getAge());
               statement.setString(4, student.getId());

               int result = statement.executeUpdate();
               log.info("prepared update() : {}", result);
               return result;

          }catch(SQLException e){
               throw new RuntimeException(e);
          }
     }

     @Override
     public int deleteById(String id){
          String sql = "delete from jdbc_students where id=?";

          try(Connection connection = DBUtils.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql);
          ) {
               statement.setString(1, id);
               int result = statement.executeUpdate();
               log.debug("result:{}",result);
               return result;
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
     }
}
