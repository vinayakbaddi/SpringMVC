package com.way2learnonline.tests;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.DeploymentRepository;
import com.way2learnonline.repository.ServerGroupRepository;
import com.way2learnonline.repository.ServerRepository;


@Configuration
public class TestConfig {

	
	@Bean
	public ServerRepository serverRepository(){
		return Mockito.mock(ServerRepository.class);
	}
	
	@Bean
	public ClusterRepository clusterRepository(){
		return Mockito.mock(ClusterRepository.class);
	}
	@Bean
	public DeploymentRepository deploymentRepository(){
		return Mockito.mock(DeploymentRepository.class);
	}
	@Bean
	public ServerGroupRepository serverGroupRepository(){
		return Mockito.mock(ServerGroupRepository.class);
	}
	
}
