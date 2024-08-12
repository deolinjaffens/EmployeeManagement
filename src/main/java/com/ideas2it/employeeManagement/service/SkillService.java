package com.ideas2it.employeeManagement.service;

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
     * @param skill - skill that has to be added
     * @return skill that is added
     */

    Skill addSkill(Skill skill);

    /**
     * <p>
     * Fetches all the available skills
     * </p>
     * @return all the available skills
     */

    List<Skill> getAllSkills();

    /**
     * <p>
     * Fetches a specific skill
     * </p>
     * @param id - id of the skill to be fetched
     * @return skill that has been fetched
     */

    Skill getSkillById(int id);

    /**
     * <p>
     * Fetches a specific skill
     * </p>
     * @param skill - skill details to be updated in the skill
     * @param id - id of the skill
     * @return skill to be updated
     */

    Skill updateSkill(Skill skill, int id);

    /**
     * <p>
     * Remove a specific skill
     * </p>
     * @param id
     */

    void removeSkill(int id);

}

