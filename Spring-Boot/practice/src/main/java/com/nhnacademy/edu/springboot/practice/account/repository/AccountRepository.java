package com.nhnacademy.edu.springboot.practice.account.repository;

import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long>{
     List<Account> findByName(String name);
}

