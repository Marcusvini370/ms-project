package com.mslearningcad.domain.exception;

public class CourseNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;

	public CourseNotFoundException(String mensagem) {
		super(mensagem);
	}

}