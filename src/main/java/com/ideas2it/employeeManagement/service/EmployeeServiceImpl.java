package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.EmployeeDao;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.mapper.DepartmentMapper;
import com.ideas2it.employeeManagement.mapper.EmployeeMapper;
import com.ideas2it.employeeManagement.mapper.SkillMapper;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import com.ideas2it.employeeManagement.util.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    SkillService skillService;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto, int departmentId) {
        Employee employee = EmployeeMapper.mapEmployee(employeeDto);
        employee.setDepartment(departmentService.getDepartment(departmentId));
//        employee.setDepartment(DepartmentMapper.mapDepartment(departmentService.getDepartmentById(departmentId)));
        return EmployeeMapper.mapEmployeeDto(employeeDao.save(employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = new ArrayList<>();
        for (Employee employee : employeeDao.findAllEmployees()) {
            employees.add(EmployeeMapper.mapEmployeeDto(employee));
        }
        return employees;
    }

    @Override
    public EmployeeDto getEmployeeById(int id) {
        return (employeeDao.findById(id).isPresent() ? EmployeeMapper.mapEmployeeDto(employeeDao.findById(id).get()) : null);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, int id) {
        Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        employee.setName(employeeDto.getName());
        employee.setDob(employeeDto.getDob());
        employee.setGender(employeeDto.getGender());
        employee.setSalary(employeeDto.getSalary());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        return EmployeeMapper.mapEmployeeDto(employeeDao.save(employee));
    }

    @Override
    public void removeEmployee(int id) {
        Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        employee.setDeleted(true);
        employeeDao.save(employee);
    }

    @Override
    public void addEmployeeToSkill(int id, int skillId) {
        Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        employee.getSkills().add(SkillMapper.mapSkill(skillService.getSkillById(skillId)));
        employeeDao.save(employee);
    }

    @Override
    public List<SkillDto> getSkillsByEmployee(int id) {
        List<SkillDto> skills = new ArrayList<>();
        Employee employee = employeeDao.findById(id).isPresent() ? employeeDao.findById(id).get() : null;
        if (null != employee) {
            for (Skill skill : employee.getSkills()) {
                skills.add(SkillMapper.mapSkillDto(skill));
                System.out.println(SkillMapper.mapSkillDto(skill));
            }
        } else {
            throw new NullPointerException("Employee of id " + id + " not found");
        }
        return skills;
    }
}
