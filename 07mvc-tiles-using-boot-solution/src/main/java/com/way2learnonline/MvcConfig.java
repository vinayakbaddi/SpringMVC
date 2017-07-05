package com.way2learnonline;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@ComponentScan(basePackages={"com.way2learnonline.controllers"})
@Configuration
@EnableAutoConfiguration
public class MvcConfig {
	
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
		tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
		return tilesConfigurer;
	}

}
