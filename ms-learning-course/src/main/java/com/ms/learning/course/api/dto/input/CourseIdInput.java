package com.ms.learning.course.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CourseIdInput {

    private UUID courseId;
}
