package com.mslearningattendance.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttendancesDTO {

    private LocalDateTime classDate;
    private boolean attendanceStatus;

}
