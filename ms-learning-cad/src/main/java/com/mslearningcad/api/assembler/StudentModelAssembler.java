package com.mslearningcad.api.assembler;

import com.mslearningcad.api.dto.StudentDTO;
import com.mslearningcad.domain.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO toModel(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    public List<StudentDTO> toCollectionModel(List<Student> Students) {
        return Students.stream()
                .map(student -> toModel(student))
                .collect(Collectors.toList());
    }

}