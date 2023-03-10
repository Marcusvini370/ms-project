package com.mslearningattendance.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@Data
@RedisHash("student")
public class Student {

    @Id
    @Indexed
    private UUID studentId;
    private String fullName;
    private UUID courseId;
}