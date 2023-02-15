package com.mslearningcad.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {
    private String fullName;
    private String document;
    private LocalDate birthDate;
    private String courseName;
    private Boolean status;
}