package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
     * @param employee     - employee that has to be added
     * @param departmentId - id of the department to which employee has to be added
     * @return employee that is added
     */

    Employee addEmployee(Employee employee, int departmentId);

    /**
     * <p>
     * Fetches all the available employees
     * </p>
     *
     * @return all the available employees
     */

    List<Employee> getAllEmployees();

    /**
     * <p>
     * Fetches a specific employee
     * </p>
     *
     * @param id - id of the employee to be fetched
     * @return employee that has been fetched
     */

    Employee getEmployeeById(int id);

    /**
     * <p>
     * Fetches a specific employee
     * </p>
     *
     * @param employee - employee details to be updated in the employee
     * @param id       - id of the employee
     * @return employee to be updated
     */

    Employee updateEmployee(Employee employee, int id);

    /**
     * <p>
     * Remove a specific employee
     * </p>
     *
     * @param id
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

    Set<Skill> getSkillsByEmployee(int id);
}
