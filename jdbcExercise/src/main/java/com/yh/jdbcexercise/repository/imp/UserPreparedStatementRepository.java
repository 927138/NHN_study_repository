package com.yh.jdbcexercise.repository.imp;

import com.yh.jdbcexercise.util.DBUtils;
import com.yh.jdbcexercise.domain.User;
import com.yh.jdbcexercise.repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserPreparedStatementRepository implements UserRepository {
     @Override
     public Optional<User> findByUserIdAndUserPassword(String userId, String userPassword) {
          //todo#11 -PreparedStatement- 아이디 , 비밀번호가 일치하는 회원조회
          String sql = "select user_id, user_name, user_password from jdbc_users where user_id=? and user_password=?";
          log.debug("sql:{}",sql);
          ResultSet rs = null;
          try(Connection connection = DBUtils.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql);
          ) {
               statement.setString(1,userId);
               statement.setString(2,userPassword);
               rs = statement.executeQuery();

               if(rs.next()){
                    return Optional.of(
                            new User(rs.getString("user_id"),rs.getString("user_name"),rs.getString("user_password"))
                    );
               }
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }finally {
               try {
                    rs.close();
               } catch (SQLException e) {
                    throw new RuntimeException(e);
               }
          }
          return Optional.empty();
     }

     @Override
     public Optional<User> findById(String userId) {
          //todo#12-PreparedStatement-회원조회
          String sql = "select user_id, user_name, user_password from jdbc_users where user_id=?";
          ResultSet rs = null;
          try(Connection connection = DBUtils.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql);
          ) {
               statement.setString(1,userId);
               rs = statement.executeQuery();
               if(rs.next()){
                    return Optional.of(
                            new User(rs.getString("user_id"),rs.getString("user_name"),rs.getString("user_password"))
                    );
               }
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }finally {
               try {
                    rs.close();
               } catch (SQLException e) {
                    throw new RuntimeException(e);
               }
          }
          return Optional.empty();
     }

     @Override
     public int save(User user) {
          //todo#13-PreparedStatement-회원저장
          String sql = "insert into jdbc_users (user_id, user_name, user_password) values (?,?,?)";

          try(Connection connection = DBUtils.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql);
          ){
               statement.setString(1,user.getId());
               statement.setString(2, user.getName());
               statement.setString(3,user.getPassword());

               int result = statement.executeUpdate();
               log.debug("save-result:{}", result);
               return result;
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
     }

     @Override
     public int updateUserPasswordByUserId(String userId, String userPassword) {
          //todo#14-PreparedStatement-회원정보 수정
          String sql = "update jdbc_users set user_password=? where user_id=?";
          log.debug("sql:{}",sql);
          try(Connection connection = DBUtils.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql);
          ){
               statement.setString(1,userPassword);
               statement.setString(2,userId);
               int result = statement.executeUpdate();
               log.debug("updateUserPasswordByUserId : {}", result);
               return result;
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
     }

     @Override
     public int deleteByUserId(String userId) {
          //todo#15-PreparedStatement-회원삭제
          String sql = "delete from jdbc_users where user_id=?";
          log.debug("sql:{}",sql);
          try(Connection connection = DBUtils.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql);
          ){
               statement.setString(1,userId);
               int result = statement.executeUpdate();
               log.debug("result:{}", result);
               return result;
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
     }
}
