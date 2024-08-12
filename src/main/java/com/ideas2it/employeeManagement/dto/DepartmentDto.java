package com.ideas2it.employeeManagement.dto;

import com.ideas2it.employeeManagement.model.Employee;
import lombok.Data;

import java.util.Set;

/**
 * <p>
 *
 * </p>
 */
@Data
public class DepartmentDto {

    private int id;
    private String name;

    private Set<Employee> employees;
}
