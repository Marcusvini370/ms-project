package com.mslearningcad.api.openapi.controller;

import com.mslearningcad.api.dto.StudentDTO;
import com.mslearningcad.api.dto.input.StudentIdInput;
import com.mslearningcad.api.dto.input.StudentInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "Students")
public interface StudentOpenApiController {

    @Operation(summary = "Search for a course by studentId",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "studentId is invalid",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Student not found",
                            content = @Content(schema = @Schema(ref = "Problem404"))
                    ),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(schema = @Schema(ref = "Problem500"))
                    )
            })
     ResponseEntity<StudentIdInput> createStudent(@Parameter(ref = "studentId", example = "8761c9b2-2565-4272-8804-f9f1b86df9dd") StudentInput studentInput);


    @Operation(summary = "Create a new student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created student"),
            @ApiResponse(responseCode = "400", description = "Student fields invalid")
    })
     ResponseEntity<StudentDTO> getStudentById( UUID studentId);


}
