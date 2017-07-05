package com.way2learnonline.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
	
	//@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Course Not Found!!!!")
	public class CourseNotFoundException extends RuntimeException {
	
		private static final long serialVersionUID = 5898035931475595958L;
	
		public CourseNotFoundException() {}
	
		public CourseNotFoundException(String message) {
			super(message);		
		}
	}

	
	