package com.example.employee;

import com.example.CommonQuerydslBinderCustomizer;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface EmployeeRepository extends
        JpaRepository<Employee, Integer>,
        QueryDslPredicateExecutor<Employee>,
        QuerydslBinderCustomizer<QEmployee>,
        CommonQuerydslBinderCustomizer<QEmployee> {
    default void customize(QuerydslBindings bindings, QEmployee root) {
        CommonQuerydslBinderCustomizer.super.customize(bindings, root);
        bindings.bind(QEmployee.employee.surname, QEmployee.employee.givenName)
                .first(StringPath::likeIgnoreCase);
    }
}
