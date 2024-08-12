package com.ideas2it.employeeManagement.dao;

import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDao extends CrudRepository<Skill,Integer> {
}
