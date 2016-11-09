package com.example.customer;

import com.example.CommonQuerydslBinderCustomizer;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface CustomerRepository extends
        JpaRepository<Customer,Integer>,
        QueryDslPredicateExecutor<Customer>,
        QuerydslBinderCustomizer<QCustomer>,
        CommonQuerydslBinderCustomizer<QCustomer> {
    @Override
    default void customize(QuerydslBindings bindings, QCustomer root) {
        CommonQuerydslBinderCustomizer.super.customize(bindings, root);
        bindings.bind(QCustomer.customer.surname, QCustomer.customer.givenName)
                .first(StringPath::likeIgnoreCase);
    }
}
