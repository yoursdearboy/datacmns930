package com.example.employee;

import com.example.CommonQuerydslBinderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface EmployeeRepository extends
        JpaRepository<Employee, Integer>,
        QueryDslPredicateExecutor<Employee>,
        CommonQuerydslBinderCustomizer<QEmployee> {
}
