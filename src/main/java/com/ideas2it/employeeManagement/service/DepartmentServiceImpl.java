package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.DepartmentDao;
import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.mapper.DepartmentMapper;
import com.ideas2it.employeeManagement.mapper.EmployeeMapper;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.util.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapDepartment(departmentDto);
        return DepartmentMapper.mapDepartmentDto(departmentDao.save(department));
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> departments = new ArrayList<>();
        for (Department department : departmentDao.findAll()) {
            departments.add(DepartmentMapper.mapDepartmentDto(department));
        }
        if (!departments.isEmpty()) {
            return departments;
        } else {
            throw new EmployeeException("Departments not found");
        }
    }

    @Override
    public DepartmentDto getDepartmentById(int id) {
        Department department = (departmentDao.findById(id).isPresent() ? departmentDao.findById(id).get() : null);
        if (null != department) {
            return DepartmentMapper.mapDepartmentDto(department);
        } else {
            throw new EmployeeException("Department Not Found");
        }
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, int id) {
        Department department = DepartmentMapper.mapDepartment(getDepartmentById(id));
        department.setName(departmentDto.getName());
        return DepartmentMapper.mapDepartmentDto(departmentDao.save(department));
    }

    @Override
    public void removeDepartment(int id) {
        departmentDao.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartment(int id) {
        List<EmployeeDto> employees = new ArrayList<>();
        for (Employee employee : departmentDao.findDepartmentWithEmployees(id)) {
            employees.add(EmployeeMapper.mapEmployeeDto(employee));
        }
        if (!employees.isEmpty()) {
            return employees;
        } else {
            throw new EmployeeException("No Employees found for the department with id " + id);
        }
    }

    @Override
    public Department getDepartment(int id) {
        Department department = (departmentDao.findById(id).isPresent() ? departmentDao.findById(id).get() : null);
        if (null != department) {
            return department;
        } else {
            throw new EmployeeException("Department Not Found");
        }
    }
}
