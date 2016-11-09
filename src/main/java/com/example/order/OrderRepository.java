package com.example.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderRepository extends
        JpaRepository<Order, Integer>,
        QueryDslPredicateExecutor<Order> {
}
