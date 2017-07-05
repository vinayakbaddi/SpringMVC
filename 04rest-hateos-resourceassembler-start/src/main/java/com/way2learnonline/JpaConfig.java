package com.way2learnonline;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

	@Configuration
	@EnableTransactionManagement
	@ComponentScan(basePackages={"com.way2learnonline.repository"})
	
	@EnableJpaRepositories(basePackages={"com.way2learnonline.repository"})
	
	public class JpaConfig {  
		
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
			HibernateJpaVendorAdapter jpaVendorAdapter= new HibernateJpaVendorAdapter();
			jpaVendorAdapter.setShowSql(true);
			
			Properties jpaProperties= new Properties();
			jpaProperties.setProperty("hibernate.format_sql", "true");
			jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
			jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
			
			LocalContainerEntityManagerFactoryBean emf= new LocalContainerEntityManagerFactoryBean();
			emf.setJpaVendorAdapter(jpaVendorAdapter);
			emf.setJpaProperties(jpaProperties);
			emf.setDataSource(dataSource());
			emf.setPackagesToScan("com.way2learnonline.model");
			
			return emf;
			
		}
	
		@Bean
		public JpaTransactionManager transactionManager( EntityManagerFactory entityManagerFactory){
			return new JpaTransactionManager(entityManagerFactory);
		}
		
		@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslator(){
			return new PersistenceExceptionTranslationPostProcessor();
		}
		
		@Bean
		public DataSource dataSource(){		
			BasicDataSource dataSource=new BasicDataSource();
			dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/ormdb");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			
			return dataSource;
		}
		
		
	}
	
