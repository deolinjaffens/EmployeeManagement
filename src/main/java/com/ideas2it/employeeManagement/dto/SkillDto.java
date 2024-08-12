package com.ideas2it.employeeManagement.dto;

import com.ideas2it.employeeManagement.model.Employee;
import lombok.Data;

import java.util.Set;

@Data
public class SkillDto {
    private int id;

    private String name;

    private Set<EmployeeDto> employees;
}
