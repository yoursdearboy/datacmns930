package com.example.order;

import com.example.CommonQuerydslBinderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderRepository extends
        JpaRepository<Order, Integer>,
        QueryDslPredicateExecutor<Order>,
        CommonQuerydslBinderCustomizer<QOrder> {
}
