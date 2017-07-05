package com.way2learnonline.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.way2learnonline.repository.AccountRepository;
import com.way2learnonline.repository.JdbcAccountRepositoryImpl;
import com.way2learnonline.repository.JdbcRewardRepositoryImpl;
import com.way2learnonline.repository.JdbcTransactionRepositoryImpl;
import com.way2learnonline.repository.RewardRepository;
import com.way2learnonline.repository.TransactionRepository;
import com.way2learnonline.service.BankService;
import com.way2learnonline.service.BankServiceImpl;
import com.way2learnonline.service.EmailService;
import com.way2learnonline.service.EmailServiceImpl;

	@Configuration
	//@Import(InfrastructureConfig.class)
	@ComponentScan(basePackages={"com.way2learnonline"})
	//@ImportResource(value={""})
	public class ApplicationConfig {
		
		
		
	
		
	
	}
