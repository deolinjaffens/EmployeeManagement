package com.ideas2it.employeeManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SkillDto {
    private int id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is Mandatory")
    @Size(min = 3, max = 30, message = "Name must be between 3 to 30 characters")
    private String name;

    private int employeeId;

    private String employeeName;
}
