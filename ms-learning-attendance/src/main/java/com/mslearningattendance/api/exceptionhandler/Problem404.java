package com.mslearningattendance.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@Schema(name = "Problem404")
public class Problem404 {

	@Schema(example = "404")
	private Integer status;

	@Schema(example = "2023-02-13T20:28:22-03:00")
	private OffsetDateTime timestamp;

	@Schema(example = "https://localhost:8083/resource-not-found")
	private String type;

	@Schema(example = "Resource not found")
	private String title;

	@Schema(example = "Resource x, which you tried to access, is non-existent.")
	private String detail;

	@Schema(example = "Resource x, which you tried to access, is non-existent.")
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