package com.mslearningattendance.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttendancesDTO {

    @Schema(example = "2023-02-15T21:08:33.633233500")
    private LocalDateTime classDate;
    @Schema(example = "false")
    private boolean attendanceStatus;

}
