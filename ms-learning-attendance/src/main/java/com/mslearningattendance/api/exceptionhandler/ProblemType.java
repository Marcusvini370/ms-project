package com.mslearningattendance.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	DADOS_INVALIDOS("/invalid-data", "Invalid data"),
	ERRO_DE_SISTEMA("/system-error", "System Error"),
	PARAMETRO_INVALIDO("/invalid-parameter", "Invalid parameter"),
	MENSAGEM_INCOMPREENSIVEL("/incomprehensible-message", "Incomprehensible message"),
	RECURSO_NAO_ENCONTRADO("/resource-not-found", "Resource not found"),
	ERRO_NEGOCIO("/business-error", "Business rule violation");

	private String title;
	private String uri;

	ProblemType(String path, String title) {
		this.uri = "http://localhost:8083" + path;
		this.title = title;
	}
}
