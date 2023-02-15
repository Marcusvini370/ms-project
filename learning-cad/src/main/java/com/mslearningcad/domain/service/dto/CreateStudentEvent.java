package com.mslearningcad.domain.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class CreateStudentEvent implements Serializable {
    private UUID studentId;
    private String fullName;
    private UUID courseId;
}