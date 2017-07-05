package com.way2learnonline;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@ComponentScan(basePackages={"com.way2learnonline.controllers"})
@Configuration
@EnableAutoConfiguration
public class MvcConfig  extends  WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver tilesViewResolver(){
		TilesViewResolver viewResolver= new TilesViewResolver();
		viewResolver.setOrder(2);
		return viewResolver;
	}
	
	@Bean
	public ViewResolver beanNameViewResolver(){
		BeanNameViewResolver viewResolver= new BeanNameViewResolver();
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	/*@Bean
	public ViewResolver contentNegotiatingViewResolver(){
		ContentNegotiatingViewResolver viewResolver= new ContentNegotiatingViewResolver();
		viewResolver.setOrder(0);
		return viewResolver;
	}*/
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer= new TilesConfigurer();
		//tilesConfigurer.set
		tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
		return tilesConfigurer;
	}
	
	/*@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true);
	}*/
	
	

}
