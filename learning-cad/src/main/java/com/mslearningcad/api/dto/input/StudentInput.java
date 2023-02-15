package com.mslearningcad.api.dto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class StudentInput {

    private String firstName;
    private String lastName;
    private String document;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private UUID courseId;
}
