package com.ideas2it.employeeManagement.mapper;

import com.ideas2it.employeeManagement.dto.DepartmentDto;
import com.ideas2it.employeeManagement.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

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
}
