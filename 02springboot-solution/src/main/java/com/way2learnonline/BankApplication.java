package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.way2learnonline.service.BankService;

	@SpringBootApplication//(exclude=DataSourceAutoConfiguration.class)	
	public class BankApplication {			
				
		
		public static void main(String[] args) throws Exception {			
			
			ApplicationContext context=SpringApplication.run(BankApplication.class,args);
			BankService bankService=context.getBean(BankService.class);		
			bankService.transfer(new Long(1), new Long(2),1000);	
		}
	
	}

	