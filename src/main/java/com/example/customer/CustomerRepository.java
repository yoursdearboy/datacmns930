package com.example.customer;

import com.example.CommonQuerydslBinderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CustomerRepository extends
        JpaRepository<Customer,Integer>,
        QueryDslPredicateExecutor<Customer>,
        CommonQuerydslBinderCustomizer<QCustomer> {
}
