package com.ideas2it.employeeManagement.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    private int id;

    @NotNull(message =  "Name is mandatory")
    @NotBlank(message =  "Name is mandatory")
    @Size(min = 3, max = 20, message = "Name should be between 3 to 20")
    private String name;

    private LocalDate dob;
    private char gender;

    @NotNull(message = "Phone Number is mandatory")
    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "\\d{10}",message = "Phone Number entered is not valid")
    private String phoneNumber;

    private double salary;

    private int departmentId;

    private String departmentName;

    private int skillId;

    private String age;
}
