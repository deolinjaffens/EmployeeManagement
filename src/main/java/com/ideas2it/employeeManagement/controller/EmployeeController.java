package com.ideas2it.employeeManagement.controller;

import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("api/v1/employees")
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
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.addEmployee(employeeDto, employeeDto.getDepartmentId()), HttpStatus.CREATED);
    }

    /**
     * <p>
     * Gets all the employee available
     * </p>
     *
     * @return all the employees that are available
     */

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
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
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    /**
     * <p>
     * Updates a specific employee
     * </p>
     *
     * @param employeeDto {@link EmployeeDto}- employee that has to updated
     * @param id          - id of the employee that has to be updated
     * @return updated employee
     */

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDto, id), HttpStatus.OK);
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
    public ResponseEntity<List<SkillDto>> getSkillsByEmployee(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getSkillsByEmployee(id), HttpStatus.OK);
    }
}
