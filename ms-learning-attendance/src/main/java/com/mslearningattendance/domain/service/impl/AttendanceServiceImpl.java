package com.mslearningattendance.domain.service.impl;

import com.mslearningattendance.api.dto.AttendanceInput;
import com.mslearningattendance.domain.model.Attendance;
import com.mslearningattendance.domain.model.Student;
import com.mslearningattendance.domain.repository.AttendanceRepository;
import com.mslearningattendance.domain.repository.StudentRepository;
import com.mslearningattendance.domain.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    @Override
    public void registerStudentAttendance(AttendanceInput attendanceInput,UUID studentId, UUID courseId) {

        Object studentAll = studentRepository.findAll();

        Object student = studentRepository.findById(studentId);
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                   //     "Student not found for course id!"));

        Attendance attendance = new Attendance();
       // attendance.setStudentId(student.getStudentId());
       // attendance.setCourseId(student.getCourseId());
        attendance.setClassDate(LocalDateTime.now());
        attendance.setAttendanceStatus(attendanceInput.getAttendanceStatus());
        attendanceRepository.save(attendance);
    }

}