package com.mslearningcad.domain.service;

import com.mslearningcad.domain.model.Student;

import java.util.UUID;

public interface StudentService {

    Student createStudent(Student student);
    Student getStudent(UUID studentId);


}
