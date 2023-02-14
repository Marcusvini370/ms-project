package com.ms.learning.course.api.assembler;

import com.ms.learning.course.api.dto.CourseDTO;
import com.ms.learning.course.domain.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CourseDTO toModel(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    public List<CourseDTO> toCollectionModel(List<Course> Courses) {
        return Courses.stream()
                .map(course -> toModel(course))
                .collect(Collectors.toList());
    }

}