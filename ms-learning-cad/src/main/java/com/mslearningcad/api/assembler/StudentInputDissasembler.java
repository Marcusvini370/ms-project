package com.mslearningcad.api.assembler;


import com.mslearningcad.api.dto.StudentDTO;
import com.mslearningcad.api.dto.input.StudentIdInput;
import com.mslearningcad.api.dto.input.StudentInput;
import com.mslearningcad.domain.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentInputDissasembler {

    @Autowired
    private ModelMapper modelMapper;

    public Student toDomainObject(StudentInput studentInput) {
        return modelMapper.map(studentInput, Student.class);
    }

    public StudentIdInput copyToDomainObject(Student student , Class<StudentIdInput> studentIdInput) {
      return  modelMapper.map(student, StudentIdInput.class);
    }

    public StudentDTO copyToDomainObjectDTO(Student student , Class<StudentDTO> studentDTO) {
        return  modelMapper.map( student,  StudentDTO.class);
    }

}