package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.EmployeeDao;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import com.ideas2it.employeeManagement.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    
    @Mock
    private EmployeeDao employeeDao;

    @Mock
    private DepartmentServiceImpl departmentService;

    @Mock
    private SkillServiceImpl skillService;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;
    private Employee responseEmployee;
    private EmployeeDto employeeDto;
    private EmployeeDto responseEmployeeDto;
    private Department department;
    private Department responseDepartment;

    @BeforeEach
    void beforeEach() {
        int departmentId = 2;
        employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        employeeDto.setName("Hayden");
        employeeDto.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employeeDto.setGender('M');
        employeeDto.setPhoneNumber("9876543210");
        employeeDto.setSalary(23456);
        employeeDto.setDepartmentId(2);
        employee = new Employee();
        employee.setId(1);
        employee.setName("Hayden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employee.setGender('M');
        employee.setPhoneNumber("9876543210");
        employee.setSalary(23456);
        department = new Department();
        department.setId(departmentId);
        department.setName("Hr");
        employee.setDepartment(department);
        responseEmployeeDto = new EmployeeDto();
        responseEmployeeDto.setId(1);
        responseEmployeeDto.setName("Hayden");
        responseEmployeeDto.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        responseEmployeeDto.setGender('M');
        responseEmployeeDto.setPhoneNumber("9876543210");
        responseEmployeeDto.setSalary(23456);
        responseEmployeeDto.setDepartmentId(department.getId());
        responseEmployeeDto.setDepartmentName(department.getName());
        responseEmployeeDto.setAge(DateUtil.calculateAge(employeeDto.getDob()));
        responseEmployee = new Employee();
        responseEmployee.setId(1);
        responseEmployee.setName("Hayden");
        responseEmployee.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        responseEmployee.setGender('M');
        responseEmployee.setPhoneNumber("9876543210");
        responseEmployee.setSalary(23456);
        responseEmployee.setDepartment(department);
    }

    @Test
    void testAddEmployee() {
        when(departmentService.getDepartment(2)).thenReturn(department);
        when(employeeDao.save(any(Employee.class))).thenReturn(responseEmployee);
        EmployeeDto result = employeeService.addEmployee(employeeDto, department.getId());
        assertEquals(1, result.getId());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeDto> employeeDto = new ArrayList<>();
        employees.add(responseEmployee);
        employeeDto.add(this.responseEmployeeDto);
        when(employeeDao.findAllEmployees()).thenReturn(employees);
        List<EmployeeDto> result = employeeService.getAllEmployees();
        assertEquals(employeeDto,result);
    }

    @Test
    void testGetEmployeeById() {
        when(employeeDao.findById(1)).thenReturn(Optional.of(responseEmployee));
        EmployeeDto result = employeeService.getEmployeeById(1);
        assertEquals(responseEmployeeDto,result);
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setName("Harden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 5));
        employee.setGender('M');
        employee.setPhoneNumber("9876543217");
        employee.setSalary(24536);
        employee.setId(1);
        employee.setDepartment(department);
        when(employeeDao.findById(1)).thenReturn(Optional.of(employee));
        when(employeeDao.save(employee)).thenReturn(responseEmployee);
        EmployeeDto result = employeeService.updateEmployee(employeeDto,1);
        assertEquals(responseEmployeeDto,result);
    }

    @Test
    void testRemoveEmployee() {
        when(employeeDao.findById(1)).thenReturn(Optional.of(employee));
        employeeService.removeEmployee(1);
        verify(employeeDao).save(employee);
        assertTrue(employee.isDeleted());
    }

    @Test
    void testGetSkillsByEmployee() {
        int skillId = 1;
        List<SkillDto> skills = new ArrayList<>();
        Skill skill = new Skill();
        skill.setName("Java");
        skill.setId(skillId);
        SkillDto skillDto = new SkillDto();
        skillDto.setName("Java");
        skillDto.setId(skillId);
        skills.add(skillDto);
        responseEmployee.setSkills(new HashSet<>());
        responseEmployee.getSkills().add(skill);
        when(employeeDao.findById(1)).thenReturn(Optional.of(responseEmployee));
        List<SkillDto> result = employeeService.getSkillsByEmployee(1);
        assertEquals(skills,result);
    }

    @Test
    void testAddEmployeeToSkill() {
        int skillId = 1;
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skillId);
        skillDto.setName("Java");
        responseEmployee.setSkills(new HashSet<>());
        when(employeeDao.findById(1)).thenReturn(Optional.of(responseEmployee));
        when(skillService.getSkillById(skillId)).thenReturn(skillDto);
        employeeService.addEmployeeToSkill(1, skillId);
        verify(employeeDao).save(employee);
    }
}
