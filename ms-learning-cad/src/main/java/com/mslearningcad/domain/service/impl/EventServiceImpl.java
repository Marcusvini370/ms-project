package com.mslearningcad.domain.service.impl;

import com.google.gson.Gson;
import com.mslearningcad.domain.model.Student;
import com.mslearningcad.domain.service.EventService;
import com.mslearningcad.domain.service.dto.CreateStudentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventServiceImpl implements EventService {

    private final ModelMapper modelMapper;
    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    @Override
    public void sendEventToKafka(Student student) {
        CreateStudentEvent createStudentEvent = modelMapper.map(student, CreateStudentEvent.class);
        createStudentEvent.setFullName(student.getFirstName().concat(" " + student.getLastName()));
        Gson gson = new Gson();
        String jsonString = gson.toJson(createStudentEvent);
        log.info("Sending request to topic", createStudentEvent);
        kafkaTemplate.send("student-topic", jsonString);
    }
}