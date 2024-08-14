package com.ideas2it.employeeManagement.dto;

import lombok.Data;

@Data
public class SkillDto {
    private int id;

    private String name;

    private int employeeId;

    private String employeeName;
}
