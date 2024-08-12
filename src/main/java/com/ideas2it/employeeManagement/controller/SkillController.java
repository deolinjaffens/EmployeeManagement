package com.ideas2it.employeeManagement.controller;

import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.mapper.Mapper;
import com.ideas2it.employeeManagement.model.Skill;
import com.ideas2it.employeeManagement.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Creation,Edition,removal and viewing of  skill is done.
 * Initialisation and extraction of details related to skill are given and
 * obtained
 * </p>
 *
 * @author Deolin Jaffens
 */

@RestController
@RequestMapping("api/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    /**
     * <p>
     * Gets all the required details of the skill that has to be added to the
     * database
     * </p>
     *
     * @param skillDto - skill that has to be added
     * @return - skill that has been added
     */

    @PostMapping
    public SkillDto addSkill(@RequestBody SkillDto skillDto) {
        return skillService.addSkill(skillDto);
    }

    /**
     * <p>
     * Gets all the skill available
     * </p>
     *
     * @return all the skills that are available
     */

    @GetMapping
    public List<SkillDto> getAllSkills() {
        return skillService.getAllSkills();
    }

    /**
     * <p>
     * Gets a specific skill
     * </p>
     *
     * @param id - id of the skill to get
     * @return skill that has to be fetched
     */
    @GetMapping("/{id}")
    public SkillDto getSkillById(@PathVariable int id) {
        return skillService.getSkillById(id);
    }

    /**
     * <p>
     * Updates a specific skill
     * </p>
     *
     * @param skillDto - skill that has to updated
     * @param id       - id of the skill that has to be updated
     * @return updated skill
     */
    @PutMapping("/{id}")
    public SkillDto updateSkill(@RequestBody SkillDto skillDto, @PathVariable int id) {
        return skillService.updateSkill(skillDto, id);
    }

    /**
     * <p>
     * Removes a specific skill
     * </p>
     *
     * @param id - id of the skill to be removed
     */
    @DeleteMapping("/{id}")
    public void removeSkill(@PathVariable int id) {
        skillService.removeSkill(id);
    }
}
