package com.ideas2it.employeeManagement.dao;

import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDao extends CrudRepository<Skill,Integer> {

    @Query("FROM Employee e JOIN e.skills s WHERE s.id = :id AND e.isDeleted = false")
    Iterable<Employee> findSkillWithEmployees(@Param("id") int id);
}
