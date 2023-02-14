package com.ms.learning.course.api.openapi.controller;

import com.ms.learning.course.api.dto.CourseDTO;
import com.ms.learning.course.api.dto.input.CourseInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Tag(name = "Courses")
public interface CourseControllerOpenApi {

    @Operation(summary = "List all courses")
     ResponseEntity<List<CourseDTO>> findAllCourses();

    @Operation(summary = "Search for a course by courseId",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "CourseId is invalid",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Course not found",
                            content = @Content(schema = @Schema(ref = "Problem404"))
                    ),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(schema = @Schema(ref = "Problem500"))
                    )
            })
     ResponseEntity<CourseDTO> findByCourseId(@PathVariable UUID courseId);

    @Operation(summary = "Create a new cours")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created course"),
            @ApiResponse(responseCode = "400", description = "Course already exists!")
    })
     ResponseEntity<CourseDTO> createCourse(@RequestBody( description = "Representation of a new course", required = true) CourseInput course);

}
