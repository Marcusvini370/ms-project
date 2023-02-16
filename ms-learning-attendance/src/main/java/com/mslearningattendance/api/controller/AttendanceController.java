package com.mslearningattendance.api.controller;

import com.mslearningattendance.api.dto.GetAttendanceDTO;
import com.mslearningattendance.api.dto.input.AttendanceInput;
import com.mslearningattendance.domain.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/courses/{courseId}/students/{studentId}/attendances")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerStudentAttendance(@RequestBody AttendanceInput attendanceInput,
                                          @PathVariable UUID courseId,
                                          @PathVariable UUID studentId) {
        attendanceService.registerStudentAttendance(attendanceInput, courseId, studentId);
    }

    @GetMapping("/student/{studentId}/attendances")
    public GetAttendanceDTO getAttendancesByStudent(@PathVariable UUID studentId) {
        return attendanceService.getAttendancesByStudent(studentId);
    }
}