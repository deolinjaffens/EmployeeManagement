package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.DepartmentDao;
import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private DepartmentDao departmentDao;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void testAddDepartment() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Hr");
        Department department = new Department();
        department.setName("Hr");
        when(departmentDao.save(department)).thenReturn(department);
        DepartmentDto result = departmentService.addDepartment(departmentDto);
        assertEquals(departmentDto, result);
    }

    @Test
    void testGetAllDepartments() {
        Department department = new Department();
        department.setName("Hr");
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Hr");
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        departmentDtos.add(departmentDto);
        when(departmentDao.findAll()).thenReturn(departments);
        List<DepartmentDto> result = departmentService.getAllDepartments();
        assertEquals(departmentDtos, result);
    }

    @Test
    void testGetDepartmentById() {
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(2);
        departmentDto.setName("Hr");
        when(departmentDao.findById(2)).thenReturn(Optional.of(department));
        DepartmentDto result = departmentService.getDepartmentById(2);
        assertEquals(departmentDto, result);
    }

    @Test
    void testUpdateDepartment() {
        int id = 2;
        Department department = new Department();
        department.setId(id);
        department.setName("Hr");
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(id);
        departmentDto.setName("Admin");
        Department updatedDepartment = new Department();
        updatedDepartment.setId(id);
        updatedDepartment.setName("Admin");
        when(departmentDao.findById(id)).thenReturn(Optional.of(department));
        when(departmentDao.save(updatedDepartment)).thenReturn(updatedDepartment);
        DepartmentDto result = departmentService.updateDepartment(departmentDto,id);
        assertEquals(departmentDto, result);
    }

    @Test
    void testRemoveDepartment() {
        int id = 1;
        departmentService.removeDepartment(id);
        verify(departmentDao,times(1)).deleteById(id);
    }

    @Test
    void testGetEmployeesByDepartment() {
        int id = 2;
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Hayden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employee.setGender('M');
        employee.setPhoneNumber("9876543210");
        employee.setSalary(23456);
        Department department = new Department();
        department.setId(id);
        department.setName("Hr");
        employee.setDepartment(department);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        List<EmployeeDto> employeesDto = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        employeeDto.setName("Hayden");
        employeeDto.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employeeDto.setGender('M');
        employeeDto.setPhoneNumber("9876543210");
        employeeDto.setSalary(23456);
        employeeDto.setAge(DateUtil.calculateAge(employeeDto.getDob()));
        employeeDto.setDepartmentName(department.getName());
        employeeDto.setDepartmentId(id);
        employeesDto.add(employeeDto);
        when(departmentDao.findDepartmentWithEmployees(id)).thenReturn(employees);
        List<EmployeeDto> result = departmentService.getEmployeesByDepartment(id);
        assertEquals(employeesDto,result);
    }

    @Test
    void testGetDepartment() {
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        when(departmentDao.findById(2)).thenReturn(Optional.of(department));
        Department result = departmentService.getDepartment(2);
        assertEquals(department.getId(),result.getId());
    }
}
