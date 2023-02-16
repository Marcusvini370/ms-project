package com.mslearningattendance.api.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AttendanceInput {
    @Schema(example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean attendanceStatus;
}