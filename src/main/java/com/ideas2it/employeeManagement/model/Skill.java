package com.ideas2it.employeeManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * <p>
 * Represents the skill in the application
 * </p>
 */

@Data
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Employee> employees;
}
