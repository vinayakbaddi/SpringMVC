package com.way2learnonline;

import javax.servlet.ServletContext;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

public class Way2LearnApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MvcConfig.class);
	}
	
}
