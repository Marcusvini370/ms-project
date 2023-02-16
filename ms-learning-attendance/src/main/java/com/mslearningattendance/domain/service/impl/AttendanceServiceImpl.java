package com.mslearningattendance.domain.service.impl;

import com.mslearningattendance.api.dto.GetAttendanceDTO;
import com.mslearningattendance.api.dto.input.AttendanceInput;
import com.mslearningattendance.client.CourseClient;
import com.mslearningattendance.client.dto.CourseDTO;
import com.mslearningattendance.domain.exception.StudentNotFoundException;
import com.mslearningattendance.domain.model.Attendance;
import com.mslearningattendance.domain.model.Student;
import com.mslearningattendance.domain.repository.AttendanceRepository;
import com.mslearningattendance.domain.repository.StudentRepository;
import com.mslearningattendance.domain.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class AttendanceServiceImpl implements AttendanceService {

    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    private final CourseClient courseClient;

    @Override
    public void registerStudentAttendance(AttendanceInput attendanceInput, UUID courseId, UUID studentId) {

        Student student = searchOrFailed(studentId);

        CourseDTO courseDTO = courseClient.getCourseId(courseId).getBody();

        Attendance attendance = new Attendance();
        attendance.setStudentId(student.getStudentId());
        attendance.setCourseId(student.getCourseId());
        attendance.setClassDate(LocalDateTime.now());
        attendance.setAttendanceStatus(attendanceInput.getAttendanceStatus());
        attendanceRepository.save(attendance);

    }

    @Override
    public GetAttendanceDTO getAttendancesByStudent(UUID studentId) {

        Student student = searchOrFailed(studentId);
        CourseDTO courseDTO = courseClient.getCourseId(student.getCourseId()).getBody();

        GetAttendanceDTO getAttendanceDTO = new GetAttendanceDTO();

        getAttendanceDTO.setFullname(student.getFullName());
        getAttendanceDTO.setCourseName(courseDTO.getCourseName());
        attendanceRepository.findAll();

        List<Attendance> attendances = attendanceRepository.findAllByStudentId(student.getStudentId());
        log.info(attendances);
       // getAttendanceDTO.setAttendancesDTO(attendances);


        return getAttendanceDTO;
    }


    public Student searchOrFailed(UUID studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(String.format("No Student found with courseID %s", studentId)));
    }

}