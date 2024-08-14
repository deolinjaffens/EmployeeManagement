package com.ideas2it.employeeManagement.dao;

import com.ideas2it.employeeManagement.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.isDeleted = false")
    Iterable<Employee> findAllEmployees();

    @Query("From Employee e LEFT JOIN FETCH e.skills where e.id = :id AND e.isDeleted = false")
    Optional<Employee> findById(@Param("id") int id);
}
