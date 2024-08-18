package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.EmployeeDao;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.mapper.EmployeeMapper;
import com.ideas2it.employeeManagement.mapper.SkillMapper;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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

    private MockedStatic<EmployeeMapper> mockStatic;

    @BeforeEach
    public void beforeEach() {
        mockStatic = Mockito.mockStatic(EmployeeMapper.class);
    }

    @AfterEach
    public void afterEach() {
        mockStatic.close();
    }
    @Test
    void testAddEmployee() {
        int departmentId = 2;
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Hayden");
        employeeDto.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employeeDto.setGender('M');
        employeeDto.setPhoneNumber("9876543210");
        employeeDto.setSalary(23456);
        Employee employee = new Employee();
        employee.setName("Hayden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employee.setGender('M');
        employee.setPhoneNumber("9876543210");
        employee.setSalary(23456);
        Department department = new Department();
        department.setId(departmentId);
        department.setName("Hr");
        //mockStatic(EmployeeMapper.class);
        when(departmentService.getDepartment(departmentId)).thenReturn(department);
        when(EmployeeMapper.mapEmployee(employeeDto)).thenReturn(employee);
        employee.setDepartment(department);
        when(EmployeeMapper.mapEmployeeDto(employee)).thenReturn(employeeDto);
        when(EmployeeMapper.mapEmployeeDto(employeeDao.save(employee))).thenReturn(employeeDto);
        employee.setDepartment(department);
        EmployeeDto result =employeeService.addEmployee(employeeDto,departmentId);
        assertEquals(EmployeeMapper.mapEmployeeDto(employee), result);

    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeDto> employeeDto = new ArrayList<>();
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        Employee employee = new Employee();
        employee.setName("Hayden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employee.setGender('M');
        employee.setPhoneNumber("9876543210");
        employee.setSalary(23456);
        employee.setDepartment(department);
        //mockStatic(EmployeeMapper.class);
        employees.add(employee);
        when(employeeDao.findAllEmployees()).thenReturn(employees);
        employeeDto.add(EmployeeMapper.mapEmployeeDto(employee));
        List<EmployeeDto> result = employeeService.getAllEmployees();
        assertEquals(employeeDto,result);
    }

    @Test
    void testGetEmployeeById() {
        int id = 1;
        Employee employee = new Employee();
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        employee.setName("Hayden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employee.setGender('M');
        employee.setPhoneNumber("9876543210");
        employee.setSalary(23456);
        employee.setId(id);
        employee.setDepartment(department);
        when(employeeDao.findById(id)).thenReturn(Optional.of(employee));
        EmployeeDto employeeDto = EmployeeMapper.mapEmployeeDto(employee);
        EmployeeDto result = employeeService.getEmployeeById(id);
        assertEquals(employeeDto,result);
    }

    @Test
    void testUpdateEmployee() {
        int id = 1;
        EmployeeDto employeeDto = new EmployeeDto();
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        employeeDto.setName("Hayden");
        employeeDto.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employeeDto.setGender('M');
        employeeDto.setPhoneNumber("9876543210");
        employeeDto.setSalary(23456);
        employeeDto.setId(id);
        Employee employee = new Employee();
        employee.setName("Harden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 5));
        employee.setGender('M');
        employee.setPhoneNumber("9876543217");
        employee.setSalary(24536);
        employee.setId(id);
        employee.setDepartment(department);
        when(EmployeeMapper.mapEmployee(employeeService.getEmployeeById(id))).thenReturn(employee);
        EmployeeDto result = employeeService.updateEmployee(employeeDto,id);
        assertEquals(EmployeeMapper.mapEmployeeDto(employee),result);
    }

    @Test
    void testRemoveEmployee() {
        int id = 1;
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        Employee employee = new Employee();
        employee.setName("Harden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 5));
        employee.setGender('M');
        employee.setPhoneNumber("9876543217");
        employee.setSalary(24536);
        employee.setId(id);
        employee.setDepartment(department);
        employee.setDeleted(false);
        when(EmployeeMapper.mapEmployee(employeeService.getEmployeeById(id))).thenReturn(employee);
        employeeService.removeEmployee(id);
        verify(employeeDao).save(employee);
        assertTrue(employee.isDeleted());
    }

    @Test
    void testGetSkillsByEmployee() {
        int id = 1;
        int skillId = 1;
        List<SkillDto> skills = new ArrayList<>();
        Skill skill = new Skill();
        skill.setName("Java");
        skill.setId(skillId);
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        Employee employee = new Employee();
        employee.setName("Harden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 5));
        employee.setGender('M');
        employee.setPhoneNumber("9876543217");
        employee.setSalary(24536);
        employee.setId(id);
        employee.setDepartment(department);
        employee.setSkills(new HashSet<>());
        employee.getSkills().add(skill);
        when(employeeDao.findById(id)).thenReturn(Optional.of(employee));
        skills.add(SkillMapper.mapSkillDto(skill));
        List<SkillDto> result = employeeService.getSkillsByEmployee(id);
        assertEquals(skills.size(),result.size());
    }

    @Test
    void testAddEmployeeToSkill() {
        int skillId = 1;
        int id = 1;
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skillId);
        skillDto.setName("Java");
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(id);
        employeeDto.setName("Hayden");
        employeeDto.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employeeDto.setGender('M');
        employeeDto.setPhoneNumber("9876543210");
        employeeDto.setSalary(23456);
        Employee employee = EmployeeMapper.mapEmployee(employeeDto);
        when(employeeService.getEmployeeById(id)).thenReturn(employeeDto);
        when(skillService.getSkillById(skillId)).thenReturn(skillDto);
        employeeService.addEmployeeToSkill(id, skillId);
        verify(employeeDao).save(employee);
    }
}
