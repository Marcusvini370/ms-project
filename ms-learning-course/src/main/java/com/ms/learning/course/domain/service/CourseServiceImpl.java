package com.ms.learning.course.domain.service;

import com.ms.learning.course.domain.exception.CourseLengthException;
import com.ms.learning.course.domain.exception.CourseNotFoundException;
import com.ms.learning.course.domain.exception.CourseUniqueException;
import com.ms.learning.course.domain.model.Course;
import com.ms.learning.course.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Optional<Course> findByCourseId(UUID courseId) {
        return Optional.ofNullable(searchOrFailed(courseId));
    }

    @Override
    public Optional<List<Course>> findAllCourses() {
        return Optional.of(courseRepository.findAll());
    }

    @Override
    public Course save(Course course) {

        if(course.getCourseName().length() <= 3){
            throw new CourseLengthException(String.format("Course name must contain more than 3 characters"));
        }

        Optional<Course> validCourse = courseRepository.findByCourseName(course.getCourseName());
        if (validCourse.isPresent()){
            throw new CourseUniqueException(String.format("There is already a course registered with that name"));
        }

        course.setCourseId(UUID.randomUUID());
        course.setStatus(true);
        course.setCreatedOn(OffsetDateTime.now());
        return courseRepository.save(course);
    }

    public Course searchOrFailed(UUID courseId) {
        return courseRepository.findByCourseId(courseId)
                .orElseThrow(() -> new CourseNotFoundException(String.format("No course found with courseID %s", courseId)));
    }

}
