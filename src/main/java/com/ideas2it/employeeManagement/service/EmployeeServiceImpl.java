package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.EmployeeDao;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    SkillService skillService;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Employee addEmployee(Employee employee, int departmentId) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return (employeeDao.findById(id).isPresent() ? employeeDao.findById(id).get() : null);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setDob(employee.getDob());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        return employeeDao.save(existingEmployee);
    }

    @Override
    public void removeEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employee.setDeleted(true);
        employeeDao.save(employee);
    }

    @Override
    public void addEmployeeToSkill(int id, int skillId) {
        Employee employee = getEmployeeById(id);
        employee.getSkills().add(skillService.getSkillById(skillId));
        employeeDao.save(employee);
    }

    @Override
    public Set<Skill> getSkillsByEmployee(int id) {
        return getEmployeeById(id).getSkills();
    }
}
