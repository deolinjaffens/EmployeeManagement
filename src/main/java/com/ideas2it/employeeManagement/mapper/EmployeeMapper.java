package com.ideas2it.employeeManagement.mapper;

import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.util.DateUtil;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

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
        employeeDto.setAge(DateUtil.calculateAge(employee.getDob()));
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

}
