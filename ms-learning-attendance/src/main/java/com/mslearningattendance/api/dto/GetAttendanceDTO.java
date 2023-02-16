package com.mslearningattendance.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAttendanceDTO {

    @Schema(example = "Marcus Vinicius")
    private String fullname;
    @Schema(example = "Microsserviços")
    private String courseName;
    private List<AttendancesDTO> attendancesDTO;

}
