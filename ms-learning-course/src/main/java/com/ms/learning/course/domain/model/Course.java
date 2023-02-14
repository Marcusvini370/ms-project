package com.ms.learning.course.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Document
public class Course {

    @Id
    private String id;
    @Indexed(unique = true)
    private UUID courseId;

    private String courseName;

    private boolean status;

    private OffsetDateTime createdOn;

}
