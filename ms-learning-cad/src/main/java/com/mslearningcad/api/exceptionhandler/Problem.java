package com.mslearningcad.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@Schema(name = "Problem")
public class Problem {

	@Schema(example = "400")
	private Integer status;

	@Schema(example = "2023-02-14T09:56:28.743Z")
	private OffsetDateTime timestamp;

	@Schema(example = "https://localhost:8082/dados-invalidos")
	private String type;

	@Schema(example = "Incomplete or invalid fields.")
	private String title;

	@Schema(example = "One or more fields are invalid, fill in the correct form and try again.")
	private String detail;

	@Schema(example = "One or more fields are invalid, fill in the correct form and try again.")
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