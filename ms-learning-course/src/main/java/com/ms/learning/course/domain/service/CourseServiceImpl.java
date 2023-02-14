package com.ms.learning.course.domain.service;

import com.ms.learning.course.api.assembler.CourseInputDissasembler;
import com.ms.learning.course.api.assembler.CourseModelAssembler;
import com.ms.learning.course.api.dto.CourseDTO;
import com.ms.learning.course.api.dto.input.CourseInput;
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

    @Autowired
    private CourseModelAssembler courseModelAssembler;

    @Autowired
    private CourseInputDissasembler courseInputDissasembler;


    @Override
    public CourseDTO findByCourseId(UUID courseId) {
        return courseModelAssembler.toModel(searchOrFailed(courseId));
    }

    @Override
    public List<CourseDTO> findAllCourses() {
        return courseModelAssembler.toCollectionModel(courseRepository.findAll());
    }

    @Override
    public CourseDTO save(CourseInput courseInput) {

        if(courseInput.getCourseName() == null || courseInput.getCourseName().length() <= 3){
            throw new CourseLengthException(String.format("CourseName must contain more than 3 characters"));
        }

        Optional<Course> validCourse = courseRepository.findByCourseName(courseInput.getCourseName());
        if (validCourse.isPresent()){
            throw new CourseUniqueException(String.format("There is already a course registered with that name"));
        }

        courseInput.setCourseId(UUID.randomUUID());
        courseInput.setStatus(true);
        courseInput.setCreatedOn(OffsetDateTime.now());

        Course course = courseInputDissasembler.toDomainObject(courseInput);

        return courseModelAssembler.toModel(courseRepository.save(course));
    }

    public Course searchOrFailed(UUID courseId) {
        return courseRepository.findByCourseId(courseId)
                .orElseThrow(() -> new CourseNotFoundException(String.format("No course found with courseID %s", courseId)));
    }

}
