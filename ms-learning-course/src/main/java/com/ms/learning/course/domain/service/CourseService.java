package com.ms.learning.course.domain.service;

import com.ms.learning.course.api.dto.CourseDTO;
import com.ms.learning.course.api.dto.input.CourseIdInput;
import com.ms.learning.course.api.dto.input.CourseInput;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    CourseDTO findByCourseId(UUID courseId);

    List<CourseDTO> findAllCourses();

    CourseIdInput save(CourseInput course);

}
