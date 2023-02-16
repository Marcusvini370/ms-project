package com.mslearningcad.api.dto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class StudentInput {

    @Schema(example = "Marcus")
    private String firstName;
    @Schema(example = "Vinicius")
    private String lastName;

    @Schema(example = "000.000.000.00")
    private String document;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Schema(example = "24/10/1999")
    private LocalDate birthDate;

    @Schema(example = "9938df42-9a9c-425c-8ca3-2c2d1613f089")
    private UUID courseId;
}
