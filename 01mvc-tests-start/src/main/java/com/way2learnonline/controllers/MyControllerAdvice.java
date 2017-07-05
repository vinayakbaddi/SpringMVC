package com.way2learnonline.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.way2learnonline.exceptions.CourseNotFoundException;
import com.way2learnonline.exceptions.InvalidRequestException;

	@ControllerAdvice
	public class MyControllerAdvice {
		
		@ExceptionHandler(value={CourseNotFoundException.class})
		public ModelAndView handleCourseNotFound(){
			
			ModelAndView mav= new ModelAndView("coursenotfound");
			mav.addObject("someData", "If you are seeing this, then this exception "
					+ "is mapped by @ExceptionHandler(value={CourseNotFoundException.class})");
			
			return mav;
		}
			
		@ExceptionHandler(value={InvalidRequestException.class})
		public ModelAndView handleInvalidRequest(){
			
			ModelAndView mav= new ModelAndView("invalidrequest");
			mav.addObject("someData", "If you are seeing this, then this exception "
					+ "is mapped by @ExceptionHandler(value={InvalidRequestException.class})");
			
			return mav;
		}
	}
	
	


