package com.ideas2it.employeeManagement.mapper;

import com.ideas2it.employeeManagement.dto.SkillDto;
import com.ideas2it.employeeManagement.model.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    /**
     * <p>
     * Converts the skill entity into skill dto
     * </p>
     *
     * @param skill - skill that has to be mapped to dto
     * @return dto that has been mapped from entity
     */

    public static SkillDto mapSkillDto(Skill skill) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        return skillDto;
    }

    /**
     * <p>
     * Converts the skill dto to skill entity
     * </p>
     *
     * @param skillDto - skill dto that has to be converted to skill entity
     * @return entity that has to be mapped from dto
     */

    public static Skill mapSkill(SkillDto skillDto) {
        Skill skill = new Skill();
        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());
        return skill;
    }
}
