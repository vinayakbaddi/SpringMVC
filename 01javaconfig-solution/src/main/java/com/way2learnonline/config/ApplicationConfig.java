package com.way2learnonline.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	public class ApplicationConfig {
		
		@Autowired
		private DataSource dataSource;
		
		
		
		@Bean
		public AccountRepository accountRepository(){		
			return new JdbcAccountRepositoryImpl(dataSource);			
		}		
		
		@Bean
		public RewardRepository rewardRepository(){
			return  new JdbcRewardRepositoryImpl(dataSource);
		}
		@Bean
		public TransactionRepository transactionRepository(){
			return new JdbcTransactionRepositoryImpl(dataSource);
		}
		
		
		@Bean
		public EmailService emailService(){
			return new EmailServiceImpl();
		}
		
		@Bean
		public BankService bankService(){
			BankServiceImpl bankServiceImpl= new BankServiceImpl();
			bankServiceImpl.setAccountRepository(accountRepository());
			bankServiceImpl.setEmailService(emailService());
			bankServiceImpl.setRewardRepository(rewardRepository());
			bankServiceImpl.setTransactionRepository(transactionRepository());
			return bankServiceImpl;
		}
	
	}
