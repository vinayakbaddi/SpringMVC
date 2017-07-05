package com.way2learnonline;

import java.util.List;
import java.util.Properties;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.way2learnonline.controllers.SSNFormatter;


//@EnableWebMvc
@ComponentScan(basePackages={"com.way2learnonline.controllers"})
@Configuration
@EnableAutoConfiguration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
		
	}
	
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		SimpleMappingExceptionResolver simpleMappingExceptionResolver= new SimpleMappingExceptionResolver();
		
		Properties exceptionMappings= new Properties();
		exceptionMappings.put("com.way2learnonline.exceptions.CourseNotFoundException", "coursenotfound");
		exceptionMappings.put("com.way2learnonline.exceptions.InvalidRequestException", "invalidrequest");
		simpleMappingExceptionResolver.setExceptionMappings(exceptionMappings);
		simpleMappingExceptionResolver.setExceptionAttribute("ex");
		simpleMappingExceptionResolver.setDefaultErrorView("defaultErrorPage");
		
		exceptionResolvers.add(simpleMappingExceptionResolver);
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new SSNFormatter());
		super.addFormatters(registry);
	}
	
	@Bean
	public ViewResolver viewResolver(){
		TilesViewResolver viewResolver= new TilesViewResolver();
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer= new TilesConfigurer();
		//tilesConfigurer.set
		tilesConfigurer.setDefinitions("WEB-INF/tiles.xml");
		return tilesConfigurer;
	}
	
	@Bean
	@Profile("test")
	public TilesConfigurer testTilesConfigurer(){
		TilesConfigurer tilesConfigurer= new TilesConfigurer();
		//tilesConfigurer.set
		tilesConfigurer.setDefinitions("file:src/main/webapp/WEB-INF/tiles.xml");
		return tilesConfigurer;
	}
	
	
	
	
	

}
