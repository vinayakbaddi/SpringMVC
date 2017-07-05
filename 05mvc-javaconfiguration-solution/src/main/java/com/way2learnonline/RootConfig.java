package com.way2learnonline;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages={"com.way2learnonline.service","com.way2learnonline.dao"})
@Configuration
public class RootConfig  {
	
	
	@Bean
	public DataSource dataSource(){
		
		
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/way2learnonlinedb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	@Bean
	public  LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
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
