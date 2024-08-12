package com.ideas2it.employeeManagement.controller;

import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.mapper.Mapper;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * Creation,Edition,removal and viewing of  department is done.
 * Initialisation and extraction of details related to department are given and
 * obtained
 * </p>
 *
 * @author Deolin Jaffens
 */


@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * <p>
     * Gets all the required details of the department that has to be added to the
     * database
     * </p>
     *
     * @param departmentDto - department that has to be added
     * @return - department that has been added
     */

    @PostMapping
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }

    /**
     * <p>
     * Gets all the department available
     * </p>
     *
     * @return all the departments that are available
     */

    @GetMapping
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    /**
     * <p>
     * Gets a specific department
     * </p>
     *
     * @param id - id of the department to get
     * @return department that has to be fetched
     */
    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    /**
     * <p>
     * Updates a specific department
     * </p>
     *
     * @param departmentDto - department that has to updated
     * @param id            - id of the department that has to be updated
     * @return updated department
     */
    @PutMapping("/{id}")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable int id) {
        return departmentService.updateDepartment(departmentDto, id);
    }

    /**
     * <p>
     * Removes a specific department
     * </p>
     *
     * @param id - id of the department to be removed
     */

    @DeleteMapping("/{id}")
    public void removeDepartment(@PathVariable int id) {
        departmentService.removeDepartment(id);
    }

    /**
     * <p>
     * Fetches all employees of a specific department
     * </p>
     *
     * @param id - id of the department from where employees has to be fetched
     */

    @GetMapping("/{id}/employees")
    public List<EmployeeDto> getEmployeesByDepartment(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }
}
