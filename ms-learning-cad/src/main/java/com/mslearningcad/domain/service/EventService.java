package com.mslearningcad.domain.service;

import com.mslearningcad.domain.model.Student;

public interface EventService {
    void sendEventToKafka(Student student);
}