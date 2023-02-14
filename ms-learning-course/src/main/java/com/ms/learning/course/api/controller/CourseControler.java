package com.ms.learning.course.api.controller;

import com.ms.learning.course.domain.model.Course;
import com.ms.learning.course.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseControler {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Optional<List<Course>>> findAllCourses(){
        return ResponseEntity.ok(courseService.findAllCourses());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Optional<Course>> findByCourseId(@PathVariable UUID courseId){
        return ResponseEntity.ok(courseService.findByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
    }


}
