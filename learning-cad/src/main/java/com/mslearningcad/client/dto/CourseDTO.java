package com.mslearningcad.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CourseDTO {

    private UUID courseId;
    private String courseName;
    private Boolean status;
    private LocalDate createdOn;
}