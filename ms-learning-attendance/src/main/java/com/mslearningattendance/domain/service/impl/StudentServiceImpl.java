package com.mslearningattendance.domain.service.impl;

import com.mslearningattendance.domain.model.Student;
import com.mslearningattendance.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Log4j2
public class StudentServiceImpl {

    private String topicName;

    private final StudentRepository studentRepository;

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "studentKafkaListenerContainerFactory")
    public void listenTopicStudentAndSave(ConsumerRecord<String, Student> record,@Payload Student student){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
        studentRepository.save(student);
    }

}