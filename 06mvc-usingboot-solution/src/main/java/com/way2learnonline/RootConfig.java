package com.way2learnonline;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages={"com.way2learnonline.service","com.way2learnonline.dao"})
@Configuration
public class RootConfig  {
	

	@Bean
	public  LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setPackagesToScan("com.way2learnonline.entity");
		
		Properties hibernateProperties= new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		
		
		
		return localSessionFactoryBean ;
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager= 
				new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}

}
