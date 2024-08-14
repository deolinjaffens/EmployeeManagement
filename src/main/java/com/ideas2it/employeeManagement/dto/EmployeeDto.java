package com.ideas2it.employeeManagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    private int id;

    private String name;

    private LocalDate dob;

    private char gender;

    private String phoneNumber;

    private double salary;

    private int departmentId;

    private String departmentName;

    private int skillId;

    private String age;
}
