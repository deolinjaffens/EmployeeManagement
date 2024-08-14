package com.ideas2it.employeeManagement.controller;

import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * <p>
     * Gets all the required details of the department that has to be added to the
     * database
     * </p>
     *
     * @param departmentDto {@link DepartmentDto} - department that has to be added
     * @return - department that has been added
     */

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.addDepartment(departmentDto), HttpStatus.OK);
    }

    /**
     * <p>
     * Gets all the department available
     * </p>
     *
     * @return all the departments that are available
     */

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(),HttpStatus.OK);
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
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable int id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id),HttpStatus.OK);
    }

    /**
     * <p>
     * Updates a specific department
     * </p>
     *
     * @param departmentDto {@link DepartmentDto} - department that has to updated
     * @param id            - id of the department that has to be updated
     * @return updated department
     */
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable int id) {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentDto, id),HttpStatus.ACCEPTED);
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
    public ResponseEntity<List<EmployeeDto>> getEmployeesByDepartment(@PathVariable int id) {
        return new ResponseEntity<>(departmentService.getEmployeesByDepartment(id),HttpStatus.OK);

    }
}
