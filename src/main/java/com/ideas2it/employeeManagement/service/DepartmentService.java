package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * All the business operations related to departments are performed
 * </p>
 *
 * @author Deolin Jaffens
 */
@Service
public interface DepartmentService {

    /**
     * <p>
     * Adds a specific department
     * </p>
     * @param department - department that has to be added
     * @return department that is added
     */

    Department addDepartment(DepartmentDto departmentDto);

    /**
     * <p>
     * Fetches all the available departments
     * </p>
     * @return all the available departments
     */

    List<Department> getAllDepartments();

    /**
     * <p>
     * Fetches a specific department
     * </p>
     * @param id - id of the department to be fetched
     * @return department that has been fetched
     */

    Department getDepartmentById(int id);

    /**
     * <p>
     * Fetches a specific department
     * </p>
     * @param departmentDto - department details to be updated in the department
     * @param id - id of the department
     * @return department to be updated
     */

    Department updateDepartment(DepartmentDto departmentDto, int id);

    /**
     * <p>
     * Remove a specific department
     * </p>
     * @param id - id of the department to be removed
     */

    void removeDepartment(int id);
}
