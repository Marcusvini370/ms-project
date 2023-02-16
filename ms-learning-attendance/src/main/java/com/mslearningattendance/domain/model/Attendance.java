package com.mslearningattendance.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@RedisHash("attendance")
public class Attendance {

    @Id
    @Indexed
    private UUID attendanceId;

    private UUID studentId;

    private UUID courseId;

    private LocalDateTime classDate;

    private boolean attendanceStatus;

}
