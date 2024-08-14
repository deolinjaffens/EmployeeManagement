package com.ideas2it.employeeManagement.controller;

import com.ideas2it.employeeManagement.dto.EmployeeDto;
import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/v1/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    /**
     * <p>
     * Gets all the required details of the skill that has to be added to the
     * database
     * </p>
     *
     * @param skillDto {@link SkillDto}- skill that has to be added
     * @return - skill that has been added
     */

    @PostMapping
    public ResponseEntity<SkillDto> addSkill(@RequestBody SkillDto skillDto) {
        return new ResponseEntity<>(skillService.addSkill(skillDto), HttpStatus.CREATED);
    }

    /**
     * <p>
     * Gets all the skill available
     * </p>
     *
     * @return all the skills that are available
     */

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAllSkills() {
        return new ResponseEntity<>(skillService.getAllSkills(),HttpStatus.OK);
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
    public ResponseEntity<SkillDto> getSkillById(@PathVariable int id) {
        return new ResponseEntity<>(skillService.getSkillById(id),HttpStatus.OK);
    }

    /**
     * <p>
     * Updates a specific skill
     * </p>
     *
     * @param skillDto {@link SkillDto}- skill that has to updated
     * @param id       - id of the skill that has to be updated
     * @return updated skill
     */
    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> updateSkill(@RequestBody SkillDto skillDto, @PathVariable int id) {
        return new ResponseEntity<>(skillService.updateSkill(skillDto, id),HttpStatus.ACCEPTED);
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

    /**
     * <p>
     *  Fetches all the employees related to a specific skill
     * </p>
     * @param id - id of the skill for which employees has to be fetched
     */

    @GetMapping("/{id}/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployeesBySkill(@PathVariable int id) {
        return new ResponseEntity<>(skillService.getEmployeesBySkill(id),HttpStatus.OK);
    }
}
