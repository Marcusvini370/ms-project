package com.mslearningattendance.domain.service;

import com.mslearningattendance.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TopicListener { 

    private String topicName;

    private static final Logger log = LoggerFactory.getLogger(TopicListener.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "studentKafkaListenerContainerFactory")
    public void listenTopicStudent(ConsumerRecord<String, Student> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }

}