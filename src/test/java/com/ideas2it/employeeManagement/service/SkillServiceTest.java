package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.SkillDao;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
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
public class SkillServiceTest {
    
    @Mock
    SkillDao skillDao;
    
    @InjectMocks
    SkillServiceImpl skillService;

    @Test
    void testAddSkill() {
        SkillDto skillDto = new SkillDto();
        skillDto.setName("Java");
        Skill skill = new Skill();
        skill.setName("Java");
        when(skillDao.save(skill)).thenReturn(skill);
        SkillDto result = skillService.addSkill(skillDto);
        assertEquals(skillDto, result);
    }

    @Test
    void testGetAllSkills() {
        Skill skill = new Skill();
        skill.setName("Hr");
        SkillDto skillDto = new SkillDto();
        skillDto.setName("Hr");
        List<Skill> skills = new ArrayList<>();
        skills.add(skill);
        List<SkillDto> skillsDto = new ArrayList<>();
        skillsDto.add(skillDto);
        when(skillDao.findAll()).thenReturn(skills);
        List<SkillDto> result = skillService.getAllSkills();
        assertEquals(skillsDto, result);
    }

    @Test
    void testGetSkillById() {
        Skill skill = new Skill();
        skill.setId(2);
        skill.setName("Hr");
        SkillDto skillDto = new SkillDto();
        skillDto.setId(2);
        skillDto.setName("Hr");
        when(skillDao.findById(2)).thenReturn(Optional.of(skill));
        SkillDto result = skillService.getSkillById(2);
        assertEquals(skillDto, result);
    }

    @Test
    void testUpdateSkill() {
        int id = 2;
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName("Hr");
        SkillDto skillDto = new SkillDto();
        skillDto.setId(id);
        skillDto.setName("Admin");
        Skill updatedSkill = new Skill();
        updatedSkill.setId(id);
        updatedSkill.setName("Admin");
        when(skillDao.findById(id)).thenReturn(Optional.of(skill));
        when(skillDao.save(updatedSkill)).thenReturn(updatedSkill);
        SkillDto result = skillService.updateSkill(skillDto,id);
        assertEquals(skillDto, result);
    }

    @Test
    void testRemoveSkill() {
        int id = 1;
        skillService.removeSkill(id);
        verify(skillDao,times(1)).deleteById(id);
    }

    @Test
    void testGetEmployeesBySkill() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeDto> employeesDto = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        employeeDto.setName("Hayden");
        employeeDto.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employeeDto.setGender('M');
        employeeDto.setPhoneNumber("9876543210");
        employeeDto.setSalary(23456);
        employeeDto.setDepartmentId(2);
        employeeDto.setDepartmentName("Hr");
        employeeDto.setAge(DateUtil.calculateAge(employeeDto.getDob()));
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Hayden");
        employee.setDob(LocalDate.ofEpochDay(2003- 1 - 2));
        employee.setGender('M');
        employee.setPhoneNumber("9876543210");
        employee.setSalary(23456);
        employees.add(employee);
        employeesDto.add(employeeDto);
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        employee.setDepartment(department);
        when(skillDao.findSkillWithEmployees(1)).thenReturn(employees);
        List<EmployeeDto> result = skillService.getEmployeesBySkill(1);
        assertEquals(employeesDto,result);
    }
}
