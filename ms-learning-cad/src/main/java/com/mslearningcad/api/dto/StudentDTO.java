package com.mslearningcad.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {

    @Schema(example = "Marcus Vinicius")
    private String fullName;

    @Schema(example = "000.000.000.00")
    private String document;

    @Schema(example = "24/10/1999")
    private LocalDate birthDate;

    @Schema(example = "MongoDB")
    private String courseName;

    @Schema(example = "true")
    private Boolean status;
}