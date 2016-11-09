package com.example;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.DatePath;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;

public interface CommonQuerydslBinderCustomizer<T extends EntityPath<?>> extends QuerydslBinderCustomizer<T> {
    @Override
    default void customize(QuerydslBindings bindings, T root) {
        bindings.bind(LocalDate.class).all((DatePath<LocalDate> path, Collection<? extends LocalDate> value) -> {
            Iterator<? extends LocalDate> it = value.iterator();
            LocalDate first = it.next();
            if (!it.hasNext())
                return path.eq(first);
            LocalDate second = it.next();
            return path.between(first, second);
        });
    }
}
