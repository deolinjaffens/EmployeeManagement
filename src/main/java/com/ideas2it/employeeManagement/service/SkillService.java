package com.ideas2it.employeeManagement.service;

import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * All the business operations related to skills are performed
 * </p>
 * @author Deolin Jaffens
 */

@Service
public interface SkillService {
    /**
     * <p>
     * Adds a specific skill
     * </p>
     * @param skillDto {@link SkillDto}- skill that has to be added
     * @return skill that is added
     */

    SkillDto addSkill(SkillDto skillDto);

    /**
     * <p>
     * Fetches all the available skills
     * </p>
     * @return all the available skills
     */

    List<SkillDto> getAllSkills();

    /**
     * <p>
     * Fetches a specific skill
     * </p>
     * @param id - id of the skill to be fetched
     * @return skill that has been fetched
     */

    SkillDto getSkillById(int id);

    /**
     * <p>
     * Fetches a specific skill
     * </p>
     * @param skillDto {@link SkillDto} - skill details to be updated in the skill
     * @param id - id of the skill
     * @return skill that is updated
     */

    SkillDto updateSkill(SkillDto skillDto, int id);

    /**
     * <p>
     * Remove a specific skill
     * </p>
     * @param id - id of skill to be removed
     */

    void removeSkill(int id);

    /**
     * <p>
     * Fetches all the employees related to a specific skill
     * </p>
     * @param id - id of the skill for which employees has to be fetched
     * @return list of employees related to a specific skill
     */

    List<EmployeeDto> getEmployeesBySkill(int id);
}

