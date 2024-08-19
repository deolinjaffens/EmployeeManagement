package com.ideas2it.employeeManagement.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Represents the employee in the application
 * </p>
 */

@Data
@Entity
@Table(name = "employee")
@EqualsAndHashCode(exclude = "skills")
public class Employee {

    @Valid

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message =  "Name is mandatory")
    @NotBlank(message =  "Name is mandatory")
    @Size(min = 3, max = 20, message = "Name should be between 3 to 20")
    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    private static String age;

    @Column(name = "gender")
    private char gender;

    @NotNull(message = "Phone Number is mandatory")
    @NotBlank(message = "Phone Number is mandatory")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "salary")
    private double salary;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "employee_skill", joinColumns = {@JoinColumn(name = "employee_id")}, inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    private Set<Skill> skills;
}
