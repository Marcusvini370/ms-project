package com.mslearningattendance.api.assembler;


import com.mslearningattendance.api.dto.AttendancesDTO;
import com.mslearningattendance.api.dto.input.AttendanceInput;
import com.mslearningattendance.domain.model.Attendance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttendanceInputDissasembler {

    @Autowired
    private ModelMapper modelMapper;

    public Attendance toDomainObject(AttendanceInput attendanceInput) {
        return modelMapper.map(attendanceInput, Attendance.class);
    }

    public AttendancesDTO copyToDomainObject(Attendance attendance , Class<AttendancesDTO> attendancesDTO) {
        return  modelMapper.map(attendance,AttendancesDTO.class);
    }

}