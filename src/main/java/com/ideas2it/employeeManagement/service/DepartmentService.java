package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
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
     *
     * @param departmentDto {@link DepartmentDto}- department that has to be added
     * @return department that is added
     */

    DepartmentDto addDepartment(DepartmentDto departmentDto);

    /**
     * <p>
     * Fetches all the available departments
     * </p>
     *
     * @return all the available departments
     */

    List<DepartmentDto> getAllDepartments();

    /**
     * <p>
     * Fetches a specific department
     * </p>
     *
     * @param id - id of the department to be fetched
     * @return department that has been fetched
     */

    DepartmentDto getDepartmentById(int id);

    /**
     * <p>
     * Updates all the details of a specific department
     * </p>
     *
     * @param departmentDto {@link DepartmentDto}- department details to be
     *                      updated in the department
     * @param id            - id of the department
     * @return department to be updated
     */

    DepartmentDto updateDepartment(DepartmentDto departmentDto, int id);

    /**
     * <p>
     * Remove a specific department
     * </p>
     *
     * @param id - id of the department to be removed
     */

    void removeDepartment(int id);

    /**
     * <p>
     * Fetches all the employees of a specific department
     * </p>
     *
     * @param id - id of the specific department from which employees has to fetched
     * @return list of employees of a specific department
     */

    List<EmployeeDto> getEmployeesByDepartment(int id);

    /**
     * <p>
     * Fetches a specific department from the database
     * </p>
     *
     * @param id - id of the department to be fetched
     * @return department that is fetched as entity
     */

    public Department getDepartment(int id);
}
