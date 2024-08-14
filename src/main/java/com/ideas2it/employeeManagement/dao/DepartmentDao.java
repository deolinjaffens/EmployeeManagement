package com.ideas2it.employeeManagement.dao;

import com.ideas2it.employeeManagement.model.Department;
import com.ideas2it.employeeManagement.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

    @Query("FROM Employee e JOIN e.department WHERE e.department.id = :id AND e.isDeleted = false")
    Iterable<Employee> findDepartmentWithEmployees(@Param("id") int id);
}
