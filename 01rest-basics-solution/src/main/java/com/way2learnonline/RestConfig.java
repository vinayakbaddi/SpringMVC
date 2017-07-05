package com.way2learnonline;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@EnableAutoConfiguration
@ComponentScan(basePackages={"com.way2learnonline.controllers"})
@EnableWebMvc
@EnableJpaRepositories
public class RestConfig {
	

}
