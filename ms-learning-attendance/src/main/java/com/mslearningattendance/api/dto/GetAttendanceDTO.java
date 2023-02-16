package com.mslearningattendance.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAttendanceDTO {

    private String fullname;
    private String courseName;
    private List<AttendancesDTO> attendancesDTO;

}
