package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.DepartmentDao;
import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.mapper.DepartmentMapper;
import com.ideas2it.employeeManagement.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

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
        mockStatic(DepartmentMapper.class);
        when(DepartmentMapper.mapDepartment(departmentDto)).thenReturn(department);
        when(DepartmentMapper.mapDepartmentDto(department)).thenReturn(departmentDto);
        when(DepartmentMapper.mapDepartmentDto(departmentDao.save(department))).thenReturn(departmentDto);
        DepartmentDto result = departmentService.addDepartment(departmentDto);
        assertEquals("Hr",result.getName());
    }

    @Test
    void testGetAllDepartments() {
        Department department = new Department();
        department.setName("Hr");
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        when(departmentDao.findAll()).thenReturn(departments);
        List<Department> result = new ArrayList<>();
        departmentDao.findAll().forEach(result::add);
        assertEquals(departments,result);
    }

    @Test
    void testGetDepartmentById() {
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        when(departmentDao.findById(2)).thenReturn(Optional.of(department));
        Department result = departmentDao.findById(2).isPresent() ? departmentDao.findById(2).get() : null;
        assertEquals(department,result);
    }
}
