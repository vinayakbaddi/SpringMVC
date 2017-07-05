package com.way2learnonline;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EnableWebMvc
@ComponentScan(basePackages={"com.way2learnonline.controllers"})
@Configuration
@EnableAutoConfiguration
public class MvcConfig {

}
