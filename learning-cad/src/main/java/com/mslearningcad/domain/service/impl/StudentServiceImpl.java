package com.mslearningcad.domain.service.impl;

import com.mslearningcad.api.assembler.StudentInputDissasembler;
import com.mslearningcad.api.assembler.StudentModelAssembler;
import com.mslearningcad.api.dto.StudentDTO;
import com.mslearningcad.api.dto.input.StudentIdInput;
import com.mslearningcad.api.dto.input.StudentInput;
import com.mslearningcad.client.CourseClient;
import com.mslearningcad.client.dto.CourseDTO;
import com.mslearningcad.domain.exception.CourseNotFoundException;
import com.mslearningcad.domain.exception.StudentNotFoundException;
import com.mslearningcad.domain.model.Student;
import com.mslearningcad.domain.repository.StudentRepository;
import com.mslearningcad.domain.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentInputDissasembler studentInputDissasembler;

    private final StudentModelAssembler studentModelAssembler;

    private final CourseClient courseClient;

    @Override
    public StudentIdInput createStudent(StudentInput studentInput) {

        CourseDTO course = courseClient.getCourseId(studentInput.getCourseId()).getBody();

        if (course == null){
            throw new CourseNotFoundException(String.format("No Course found with courseID %s", studentInput.getCourseId()));
        }

        Student student = studentInputDissasembler.toDomainObject(studentInput);
        student.setStudentId(UUID.randomUUID());
        student.setStatus(true);
        student.setCreatedOn(LocalDateTime.now());
        studentModelAssembler.toModel(studentRepository.save(student));

        return  studentInputDissasembler.copyToDomainObject(student, StudentIdInput.class);
    }

    @Override
    public StudentDTO getStudentId(UUID studentId) {

        Student student = searchOrFailed(studentId);
        CourseDTO course = courseClient.getCourseId(student.getCourseId()).getBody();
        StudentDTO studentDTO = studentInputDissasembler.copyToDomainObjectDTO(student,StudentDTO.class);
        studentDTO.setFullName(student.getFirstName().concat(" " + student.getLastName()));
        studentDTO.setCourseName(course.getCourseName());

        return  studentDTO;
    }

    public Student searchOrFailed(UUID studentId) {
        return studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new StudentNotFoundException(String.format("No Student found with courseID %s", studentId)));
    }
}
