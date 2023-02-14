package com.ms.learning.course.api.assembler;

import com.ms.learning.course.api.dto.input.CourseInput;
import com.ms.learning.course.domain.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseInputDissasembler {

    @Autowired
    private ModelMapper modelMapper;

    public Course toDomainObject(CourseInput courseInput) {
        return modelMapper.map(courseInput, Course.class);
    }

    public void copyToDomainObject(CourseInput courseInput, Course course) {
        modelMapper.map(courseInput, course);
    }

}