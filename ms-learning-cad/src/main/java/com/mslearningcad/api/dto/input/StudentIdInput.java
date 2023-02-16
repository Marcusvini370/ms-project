package com.mslearningcad.api.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentIdInput {

    @Schema(example = "48004e78-c87f-45e5-b377-9c2cfdc2ec7c")
    private UUID studentId;
}