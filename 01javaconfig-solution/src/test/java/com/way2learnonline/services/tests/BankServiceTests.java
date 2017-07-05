package com.way2learnonline.services.tests;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.config.ApplicationConfig;
import com.way2learnonline.config.InfrastructureConfig;
import com.way2learnonline.service.BankService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class,InfrastructureConfig.class})
public class BankServiceTests {	
	
	@Autowired
	private BankService bankService;	

	@Test
	@Transactional
	public void testTransfer() throws SQLException{
		
		Long transactionId=bankService.transfer(new Long(1), new Long(2), 5000);
		assertNotNull(transactionId);
	}
	
	@Test
	@DirtiesContext
	public void testX() throws SQLException{
		
		Long transactionId=bankService.transfer(new Long(1), new Long(2), 5000);
		assertNotNull(transactionId);
	}
	
	@Test
	public void testY() throws SQLException{
		
		Long transactionId=bankService.transfer(new Long(1), new Long(2), 5000);
		assertNotNull(transactionId);
	}
	
	
	

}
