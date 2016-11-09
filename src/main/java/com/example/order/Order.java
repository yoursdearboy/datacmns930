package com.example.order;

import com.example.customer.Customer;
import com.example.employee.Employee;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "DATACMNS_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate orderedDate;
}
