package com.ms.learning.course.domain.exception;

public class CourseUniqueException extends BusinessException{
	
	private static final long serialVersionUID = 1L;
	
	public CourseUniqueException(String mensagem) {
		super(mensagem);
	}

}