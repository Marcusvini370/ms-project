package com.mslearningattendance.domain.service;

import com.mslearningattendance.api.dto.GetAttendanceDTO;
import com.mslearningattendance.api.dto.input.AttendanceInput;

import java.util.UUID;

public interface AttendanceService {
    void registerStudentAttendance(AttendanceInput attendanceInput, UUID courseId, UUID studentId);

    GetAttendanceDTO getAttendancesByStudent(UUID studentId);
}