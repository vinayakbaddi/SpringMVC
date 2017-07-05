package com.way2learnonline.controllers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

	public class MySizeValidator  implements ConstraintValidator<MySize, Integer>{
		
		int min;
		int max;
	
		@Override
		public void initialize(MySize mySize) {
			min=mySize.min();
			max=mySize.max();
			
		}
	
		@Override
		public boolean isValid(Integer value, ConstraintValidatorContext context) {
			System.err.println("MySizeValidator.isValid()");
			if(value<min || value>max){
				return false;
			}
			return true;
		}
	
	}

	
	