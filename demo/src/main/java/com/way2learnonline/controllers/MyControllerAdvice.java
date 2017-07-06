package com.way2learnonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.way2learnonline.exceptions.ServerNotFoundException;

@ControllerAdvice(assignableTypes={ServerController.class})
public class MyControllerAdvice {

	@ExceptionHandler({ServerNotFoundException.class})
	//@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage handleError(Exception e){
		
		ErrorMessage errorMessage= new ErrorMessage();
		errorMessage.setMessage(e.getMessage());
		
		return errorMessage;
		
	}
}
