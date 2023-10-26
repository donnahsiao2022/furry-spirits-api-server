package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM user_order WHERE number like %:orderNumber% and create_datetime between :startDatetime and :endDatetime order by create_datetime desc",
            countQuery = "select count(*) from user_order WHERE number like %:orderNumber% and create_datetime between :startDatetime and :endDatetime",
            nativeQuery = true)
    Page<Order> findOrderPageByCondition(@Param("orderNumber") String orderNumber,
                                         @Param("startDatetime") Date startDatetime,
                                         @Param("endDatetime") Date endDatetime,
                                         Pageable pageable);
}
