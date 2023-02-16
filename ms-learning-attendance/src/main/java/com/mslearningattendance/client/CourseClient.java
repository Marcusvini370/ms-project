package com.mslearningattendance.client;

import com.mslearningattendance.client.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "ms-learning-course", url = "http://localhost:8081/api/v1/course")
public interface CourseClient {

    @GetMapping("/{courseId}")
    ResponseEntity<CourseDTO> getCourseId(@PathVariable("courseId") UUID courseId);
}