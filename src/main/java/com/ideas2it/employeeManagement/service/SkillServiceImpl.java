package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.SkillDao;
import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDao skillDao;

    @Override
    public Skill addSkill(Skill skill) {
        return skillDao.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return (List<Skill>) skillDao.findAll();
    }

    @Override
    public Skill getSkillById(int id) {
        return (skillDao.findById(id).isPresent() ? skillDao.findById(id).get() : null);
    }

    @Override
    public Skill updateSkill(Skill skill, int id) {
        Skill existingSkill = getSkillById(id);
        existingSkill.setName(skill.getName());
        return skillDao.save(existingSkill);
    }

    @Override
    public void removeSkill(int id) {
        skillDao.deleteById(id);
    }
}
