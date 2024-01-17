package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Order;
import com.nhnacademy.springjpa.entity.OrderDetail;
import com.nhnacademy.springjpa.entity.Product;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetail.Pk> {
     Long countByOrderId_OrderDateBetween(Date startTime, Date endTime);
     List<OrderDetail> findByProductId_ProductId(Long productId);
     List<OrderDetail> findByOrderId(Order orderId);
     List<OrderDetail> findByProductId(Product productId);


}
