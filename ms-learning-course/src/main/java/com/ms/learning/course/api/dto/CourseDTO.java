package com.ms.learning.course.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Setter
@Getter
public class CourseDTO {

    @Schema(example = "1")
    private UUID courseId;

    @Schema(example = "Science")
    private String courseName;

    @Schema(example = "true")
    private boolean status;

    @Schema(example = "2023-02-14T06:56:28.7432022-03:00")
    private OffsetDateTime createdOn;
}
