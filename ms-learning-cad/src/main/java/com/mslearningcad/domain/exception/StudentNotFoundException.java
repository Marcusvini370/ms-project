package com.mslearningcad.domain.exception;

public class StudentNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String mensagem) {
		super(mensagem);
	}

}