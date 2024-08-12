package com.ideas2it.employeeManagement.mapper;

import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Converts the data transfer object into entity and vice-versa
 * </p>
 *
 * @author Deolin Jaffens
 */

@Component
public class Mapper {

    /**
     * <p>
     * Converts the department entity into department dto
     * </p>
     *
     * @param department - department that has to be mapped to dto
     * @return dto that has been mapped from entity
     */

    public static DepartmentDto mapDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }

    /**
     * <p>
     * Converts the department dto to department entity
     * </p>
     *
     * @param departmentDto - department dto that has to be converted to department entity
     * @return entity that has to be mapped from dto
     */

    public static Department mapDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        return department;
    }

    /**
     * <p>
     * Converts the employee entity into employee dto
     * </p>
     *
     * @param employee - employee that has to be mapped to dto
     * @return dto that has been mapped from entity
     */

    public static EmployeeDto mapEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setDob(employee.getDob());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setGender(employee.getGender());
        employeeDto.setDepartmentId(employee.getDepartment().getId());
        employeeDto.setDepartmentName(employee.getDepartment().getName());
        return employeeDto;
    }

    /**
     * <p>
     * Converts the employee dto to employee entity
     * </p>
     *
     * @param employeeDto - employee dto that has to be converted to employee entity
     * @return entity that has to be mapped from dto
     */

    public static Employee mapEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setDob(employeeDto.getDob());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setSalary(employeeDto.getSalary());
        employee.setGender(employeeDto.getGender());
        return employee;
    }

    /**
     * <p>
     * Converts the skill entity into skill dto
     * </p>
     *
     * @param skill - skill that has to be mapped to dto
     * @return dto that has been mapped from entity
     */

    public static SkillDto mapSkillDto(Skill skill) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        return skillDto;
    }

    /**
     * <p>
     * Converts the skill dto to skill entity
     * </p>
     *
     * @param skillDto - skill dto that has to be converted to skill entity
     * @return entity that has to be mapped from dto
     */
    public static Skill mapSkill(SkillDto skillDto) {
        Skill skill = new Skill();
        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());
        return skill;
    }
}
