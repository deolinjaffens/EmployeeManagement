package com.ideas2it.employeeManagement.controller;

import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.mapper.Mapper;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import com.ideas2it.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Creation,Edition,removal and viewing of  employee is done.
 * Initialisation and extraction of details related to employee are given and
 * obtained
 * </p>
 *
 * @author Deolin Jaffens
 */

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * <p>
     * Gets all the required details of the employee that has to be added to the
     * database
     * </p>
     *
     * @param employeeDto - employee that has to be added
     * @return - employee that has been added
     */

    @PostMapping
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto, employeeDto.getDepartmentId());
    }

    /**
     * <p>
     * Gets all the employee available
     * </p>
     *
     * @return all the employees that are available
     */

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = new ArrayList<>();
        for (Employee employee : employeeService.getAllEmployees()) {
            employees.add(Mapper.mapEmployeeDto(employee));
        }
        return employees;
    }

    /**
     * <p>
     * Gets a specific employee
     * </p>
     *
     * @param id - id of the employee to get
     * @return employee that has to be fetched
     */

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        return Mapper.mapEmployeeDto(employeeService.getEmployeeById(id));
    }

    /**
     * <p>
     * Updates a specific employee
     * </p>
     *
     * @param employeeDto - employee that has to updated
     * @param id          - id of the employee that has to be updated
     * @return updated employee
     */

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        return employeeService.updateEmployee(employeeDto, id);
    }

    /**
     * <p>
     * Removes a specific employee
     * </p>
     *
     * @param id - id of the employee to be removed
     */

    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
    }

    /**
     * <p>
     * Adds new skill to an employee
     * </p>
     *
     * @param employeeDto {@link EmployeeDto} employee to whom the new skill has to be added
     */

    @PutMapping("/skills")
    public void addEmployeeToSkill(@RequestBody EmployeeDto employeeDto) {
        employeeService.addEmployeeToSkill(employeeDto.getId(), employeeDto.getSkillId());
    }

    /**
     * <p>
     * Fetches all the skills a specific employee has
     * </p>
     *
     * @param id -id of employee whose skills has to be fetched
     * @return list of skills the employee has
     */
    @GetMapping("/{id}/skills")
    public List<SkillDto> getSkillsByEmployee(@PathVariable int id) {
        List<SkillDto> skills = new ArrayList<>();
        for (Skill skill : employeeService.getSkillsByEmployee(id)) {
            skills.add(Mapper.mapSkillDto(skill));
        }
        return skills;
    }
}
