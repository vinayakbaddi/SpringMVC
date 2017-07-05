package com.way2learnonline.tests;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.way2learnonline.service.IAboutUsService;
import com.way2learnonline.service.ICourseService;
import com.way2learnonline.service.ITestimonialService;


@Configuration
public class TestConfig {

	@Bean
	public ITestimonialService testimonialService(){
		return Mockito.mock(ITestimonialService.class);
	}
	@Bean
	public ICourseService courseService(){
		return Mockito.mock(ICourseService.class);
	}
	
	@Bean
	public IAboutUsService aboutUsService(){
		return Mockito.mock(IAboutUsService.class);
	}
}
