package com.way2learnonline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


	public class WelcomeController  implements Controller{
		
		
	
		@Override
		public ModelAndView handleRequest(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			////
			//
			//
			String data="Welcome to  Spring MVC";
			
			ModelAndView modelAndView= new ModelAndView("w");
			
			modelAndView.addObject("message", data);
			
			return modelAndView;
		}		
	}
