package com.ms.learning.course.domain.exception;

public class CourseLengthException extends BusinessException{
	
	private static final long serialVersionUID = 1L;
	
	public CourseLengthException(String mensagem) {
		super(mensagem);
	}

}