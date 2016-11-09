package com.example.order;

import com.example.CommonQuerydslBinderCustomizer;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface OrderRepository extends
        JpaRepository<Order, Integer>,
        QueryDslPredicateExecutor<Order>,
        QuerydslBinderCustomizer<QOrder>,
        CommonQuerydslBinderCustomizer<QOrder> {
    default void customize(QuerydslBindings bindings, QOrder root) {
        CommonQuerydslBinderCustomizer.super.customize(bindings, root);
        bindings.bind(QOrder.order.customer.surname, QOrder.order.customer.givenName)
                .first(StringPath::likeIgnoreCase);
    }
}
