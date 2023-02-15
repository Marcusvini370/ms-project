package com.mslearningcad.api.controller;

import com.mslearningcad.api.dto.StudentDTO;
import com.mslearningcad.api.dto.input.StudentIdInput;
import com.mslearningcad.api.dto.input.StudentInput;
import com.mslearningcad.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentIdInput> createStudent(@RequestBody StudentInput studentInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentInput));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable UUID studentId){
        return ResponseEntity.ok(studentService.getStudentId(studentId));
    }

}
