package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
     Long countByCustomerId_CustomerId(Long customerId);
     List<Order> findByCustomerId_CustomerName(String name);
     List<Order> findByOrderDateBefore(Date date);
     List<Order> findByOrderDateAfter(Date date);
     List<Order> findByOrderDateBetween(Date startDate, Date endDate);
     List<Order> findByShipDateIsNullAndOrderDateBefore(Date date);
}
