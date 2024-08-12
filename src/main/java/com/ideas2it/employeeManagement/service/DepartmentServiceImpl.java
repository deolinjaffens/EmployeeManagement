package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.DepartmentDao;
import com.ideas2it.employeeManagement.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department addDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return (departmentDao.findById(id).isPresent() ? departmentDao.findById(id).get() : null);
    }

    @Override
    public Department updateDepartment(Department department, int id) {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setName(department.getName());
        return departmentDao.save(existingDepartment);
    }

    @Override
    public void removeDepartment(int id) {
        departmentDao.deleteById(id);
    }
}
