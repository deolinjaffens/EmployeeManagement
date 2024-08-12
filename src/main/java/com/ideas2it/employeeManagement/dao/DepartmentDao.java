package com.ideas2it.employeeManagement.dao;

import com.ideas2it.employeeManagement.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

}
