package com.ms.learning.course.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@Schema(name = "Problem500")
public class Problem500 {

	@Schema(example = "500")
	private Integer status;

	@Schema(example = "2023-02-13T20:28:22-03:00")
	private OffsetDateTime timestamp;

	@Schema(example = "https://localhost:8081/system-error")
	private String type;

	@Schema(example = "System Error")
	private String title;

	@Schema(example = "An unexpected internal system error has occurred. "
			+ "Try again and if the problem persists, contact your system administrator.")
	private String detail;

	@Schema(example = "An unexpected internal system error has occurred. "
			+ "Try again and if the problem persists, contact your system administrator.")
	private String userMessage;

	@Schema(example = "Objects or fields that generated the error")
	private List<Object> objects;

	@Schema(name = "ObjectProblem")
	@Getter
	@Builder
	public static class Object {

		@Schema(example = "name")
		private String name;

		@Schema(example = "name is required")
		private String userMessage;
	}
}