package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * All the business operations related to employees are performed
 * </p>
 *
 * @author Deolin Jaffens
 */

@Service
public interface EmployeeService {
    /**
     * <p>
     * Adds a specific employee
     * </p>
     *
     * @param employeeDto  {@link EmployeeDto} - employee that has to be added
     * @param departmentId - id of the department to which employee has to be added
     * @return employee that is added
     */

    EmployeeDto addEmployee(EmployeeDto employeeDto, int departmentId);

    /**
     * <p>
     * Fetches all the available employees
     * </p>
     *
     * @return all the available employees
     */

    List<EmployeeDto> getAllEmployees();

    /**
     * <p>
     * Fetches a specific employee
     * </p>
     *
     * @param id - id of the employee to be fetched
     * @return employee that has been fetched
     */

    EmployeeDto getEmployeeById(int id);

    /**
     * <p>
     * Fetches a specific employee
     * </p>
     *
     * @param employeeDto {@link EmployeeDto} - employee details to be updated in the employee
     * @param id          - id of the employee
     * @return employee to be updated
     */

    EmployeeDto updateEmployee(EmployeeDto employeeDto, int id);

    /**
     * <p>
     * Remove a specific employee
     * </p>
     *
     * @param id - id of employee whose details has to be removed
     */

    void removeEmployee(int id);

    /**
     * <p>
     * New skill is added to an employee
     * </p>
     *
     * @param id      - id of employee to whom a specific skill has to be added
     * @param skillId - id of the skill that has to be added to an employee
     */

    void addEmployeeToSkill(int id, int skillId);

    /**
     * <p>
     * Skills of a specific employee is fetched
     * </p>
     *
     * @param id - id of the employee whose skills has to be fetched
     * @return all the skills the employee has
     */

    List<SkillDto> getSkillsByEmployee(int id);
}
