package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration
public class Test {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(Test.class);
		String[] beanNames=applicationContext.getBeanDefinitionNames();
		for(String beanName:beanNames){
			System.out.println(beanName);
		}
	}

}
