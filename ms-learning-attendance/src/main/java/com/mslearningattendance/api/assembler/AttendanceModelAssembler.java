package com.mslearningattendance.api.assembler;

import com.mslearningattendance.api.dto.GetAttendanceDTO;
import com.mslearningattendance.domain.model.Attendance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttendanceModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public GetAttendanceDTO toModel(GetAttendanceDTO attendance) {
        return modelMapper.map(attendance, GetAttendanceDTO.class);
    }


}