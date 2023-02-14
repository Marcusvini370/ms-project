package com.ms.learning.course.domain.repository;

import com.ms.learning.course.domain.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends MongoRepository<Course, UUID> {
    public Optional<Course> findByCourseName(String nome);
    public Optional<Course> findByCourseId(UUID courseId);
}
