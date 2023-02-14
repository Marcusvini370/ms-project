package com.ms.learning.course.api.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class CourseInput {

    private UUID courseId;
    @Schema(example = "Java")
    private String courseName;
    private boolean status;
    private OffsetDateTime createdOn;

}
