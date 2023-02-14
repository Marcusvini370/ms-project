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
@Schema(name = "Problema")
public class Problem {

	@Schema(example = "400")
	private Integer status;

	@Schema(example = "2023-01-03T16:39:13Z")
	private OffsetDateTime timestamp;

	@Schema(example = "https://localhost:8080/dados-invalidos")
	private String type;

	@Schema(example = "Dados inválidos")
	private String title;

	@Schema(example = "Um ou mais campos estão inválidos, Faça o preenchimento correto e tente novamente.")
	private String detail;

	@Schema(example = "Um ou mais campos estão inválidos, Faça o preenchimento correto e tente novamente.")
	private String userMessage;

	@Schema(example = "Objetos ou campos que geraram o erro")
	private List<Object> objects;


	@Schema(name = "ObjetoProblema")
	@Getter
	@Builder
	public static class Object {

		@Schema(example = "preco")
		private String name;

		@Schema(example = "Opreço é obrigatório")
		private String userMessage;
	}
}