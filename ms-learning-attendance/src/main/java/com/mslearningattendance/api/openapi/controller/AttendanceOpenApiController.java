package com.mslearningattendance.api.openapi.controller;

import com.mslearningattendance.api.dto.GetAttendanceDTO;
import com.mslearningattendance.api.dto.input.AttendanceInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Attendances")
public interface AttendanceOpenApiController {

    @Operation(summary = "Create a new attendence")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created attendance"),
            @ApiResponse(responseCode = "400", description = "Invalid attendance")
    })
     void registerStudentAttendance(@RequestBody AttendanceInput attendanceInput,
                                          @PathVariable UUID courseId,
                                          @PathVariable UUID studentId) ;

    @Operation(summary = "Search for a attendance by studentId",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "studentId is invalid",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Attendance not found",
                            content = @Content(schema = @Schema(ref = "Problem404"))
                    ),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(schema = @Schema(ref = "Problem500"))
                    )
            })
     GetAttendanceDTO getAttendancesByStudent(UUID studentId);
}
