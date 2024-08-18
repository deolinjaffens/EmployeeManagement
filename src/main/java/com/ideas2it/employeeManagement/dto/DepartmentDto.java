package com.ideas2it.employeeManagement.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepartmentDto {

    @Valid
    private int id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is Mandatory")
    @Size(min = 2, max = 30, message = "Name must be between 3 to 30 characters")
    private String name;

    private String employeeName;

    private int employeeId;
}
