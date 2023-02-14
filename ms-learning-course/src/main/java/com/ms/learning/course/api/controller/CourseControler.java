package com.ms.learning.course.api.controller;

import com.ms.learning.course.api.dto.CourseDTO;
import com.ms.learning.course.api.dto.input.CourseInput;
import com.ms.learning.course.api.openapi.controller.CourseControllerOpenApi;
import com.ms.learning.course.domain.service.CourseService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseControler implements CourseControllerOpenApi {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAllCourses(){
        return ResponseEntity.ok(courseService.findAllCourses());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDTO> findByCourseId(@Parameter(description = "ID de um cliente", example = "1", required = true) UUID courseId){
        return ResponseEntity.ok(courseService.findByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseInput course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
    }


}
