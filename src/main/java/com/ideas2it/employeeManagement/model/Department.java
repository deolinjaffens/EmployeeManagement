package com.ideas2it.employeeManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * <p>
 * Represents the department in the application
 * </p>
 */

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Employee> employees;

}
