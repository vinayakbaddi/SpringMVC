package com.way2learnonline.controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

	@Constraint(validatedBy=MySizeValidator.class)	
	@Target( { ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface MySize {
	
		String message() default " Invalid!!";
		Class<?> []groups() default {};
		Class<? extends Payload>[] payload() default {};
		
		int min();
		int max();
	}

	