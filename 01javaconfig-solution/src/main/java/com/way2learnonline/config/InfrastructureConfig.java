package com.way2learnonline.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

	
	@Configuration
	@PropertySource("classpath:db.properties")	
	public class InfrastructureConfig {	
		
		
		@Value("classpath:dbscripts.sql")private Resource dbscript;
		
		@Autowired
		private Environment env;
		
		@Bean
		public DataSource dataSource(){		
			BasicDataSource dataSource= new BasicDataSource();
			dataSource.setDriverClassName(env.getProperty("db.driverclassname"));
			dataSource.setUrl(env.getProperty("db.url"));
			dataSource.setUsername(env.getProperty("db.user"));
			dataSource.setPassword(env.getProperty("db.password"));
			return dataSource;		
		}
		
		
		/*@Bean(name="ds")
		public DataSource dataSource(){		
			BasicDataSource dataSource= new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost/springdb");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			return dataSource;		
		}*/
		
	
	
		
		@Bean
		public DataSourceInitializer dataSourceInitializer(DataSource dataSource){
			DataSourceInitializer initializer= new DataSourceInitializer();
			initializer.setDataSource(dataSource);
			initializer.setDatabasePopulator(databasePopulator());
			return initializer;
		}
		
		private DatabasePopulator databasePopulator() {
		     ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		    populator.addScript(dbscript);		   
		    return populator;
		}

	
	
	
	
	}


