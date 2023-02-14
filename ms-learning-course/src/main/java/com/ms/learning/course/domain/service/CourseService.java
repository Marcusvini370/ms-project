package com.ms.learning.course.domain.service;

import com.ms.learning.course.domain.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {

    Optional<Course> findByCourseId(UUID courseId);

    Optional<List<Course>> findAllCourses();

    Course save(Course course);

}
