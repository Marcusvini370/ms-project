package com.mslearningcad.domain.service;

import com.mslearningcad.api.dto.StudentDTO;
import com.mslearningcad.api.dto.input.StudentIdInput;
import com.mslearningcad.api.dto.input.StudentInput;

import java.util.UUID;

public interface StudentService {

    StudentIdInput createStudent(StudentInput studentInput);

    StudentDTO getStudentId(UUID studentId);
}
