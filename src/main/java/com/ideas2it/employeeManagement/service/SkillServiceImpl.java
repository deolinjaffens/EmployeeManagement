package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dao.SkillDao;
import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.mapper.EmployeeMapper;
import com.ideas2it.employeeManagement.mapper.SkillMapper;
import com.ideas2it.employeeManagement.model.Employee;
import com.ideas2it.employeeManagement.model.Skill;
import com.ideas2it.employeeManagement.util.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDao skillDao;

    @Override
    public SkillDto addSkill(SkillDto skillDto) {
        return SkillMapper.mapSkillDto(skillDao.save(SkillMapper.mapSkill(skillDto)));
    }

    @Override
    public List<SkillDto> getAllSkills() {
        List<SkillDto> skills = new ArrayList<>();
        for (Skill skill : skillDao.findAll()) {
            skills.add(SkillMapper.mapSkillDto(skill));
        }
        return skills;
    }

    @Override
    public SkillDto getSkillById(int id) {
        return (skillDao.findById(id).isPresent() ? SkillMapper.mapSkillDto(skillDao.findById(id).get()) : null);
    }

    @Override
    public SkillDto updateSkill(SkillDto skillDto, int id) {
        Skill skill = skillDao.findById(id).isPresent() ? skillDao.findById(id).get() : null;
        if (null != skill) {
            skill.setName(skillDto.getName());
            return SkillMapper.mapSkillDto(skillDao.save(skill));
        } else {
            throw new NullPointerException("skill not found for id " + id);
        }
    }

    @Override
    public void removeSkill(int id) {
        skillDao.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getEmployeesBySkill(int id) {
        List<EmployeeDto> employees = new ArrayList<>();
        for (Employee employee : skillDao.findSkillWithEmployees(id)) {
            employees.add(EmployeeMapper.mapEmployeeDto(employee));
        }
        if (!employees.isEmpty()) {
            return employees;
        } else {
            throw new EmployeeException("None of the employees is associated with the skill of id " + id);
        }
    }
}
