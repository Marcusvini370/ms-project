package com.mslearningattendance.domain.service;

import com.mslearningattendance.api.dto.AttendanceInput;

import java.util.UUID;

public interface AttendanceService {
    void registerStudentAttendance(AttendanceInput attendanceInput,UUID courseId,UUID studentId);
}