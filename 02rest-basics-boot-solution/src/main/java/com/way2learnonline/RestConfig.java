package com.way2learnonline;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.way2learnonline.controllers"})
public class RestConfig {
	

}
