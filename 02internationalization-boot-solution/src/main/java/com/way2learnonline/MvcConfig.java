package com.way2learnonline;

import java.util.Locale;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@ComponentScan(basePackages={"com.way2learnonline.controllers"})
@Configuration
@EnableAutoConfiguration
public class MvcConfig  extends WebMvcConfigurerAdapter{
	
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
	
	@Bean(name="localeResolver")
	public LocaleResolver LocaleResolver(){
		CookieLocaleResolver cookieLocaleResolver= new CookieLocaleResolver();
		cookieLocaleResolver.setCookieName("mylocalecookie");
		cookieLocaleResolver.setDefaultLocale(new Locale("en"));
		cookieLocaleResolver.setCookieMaxAge(3600);
		return cookieLocaleResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		return new LocaleChangeInterceptor();
	}
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	

}
