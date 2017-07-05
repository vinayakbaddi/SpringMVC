package com.way2learnonline;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.DispatcherServlet;

public class MyServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> classes, ServletContext context) throws ServletException {
			
		ServletRegistration.Dynamic dispatcherServlet=context.addServlet("dispatcherServlet", DispatcherServlet.class);
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");		

	}

}
