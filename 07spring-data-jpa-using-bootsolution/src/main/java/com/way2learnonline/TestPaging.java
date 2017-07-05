package com.way2learnonline;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Deployment;
import com.way2learnonline.model.Server;
import com.way2learnonline.model.ServerGroup;
import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.ClusterRepositoryUsingPagingAnsSorting;

@SpringBootApplication
public class TestPaging {

public static void main(String[] args) {
		
		
		ApplicationContext context= SpringApplication.run(TestPaging.class);
		
		ClusterRepositoryUsingPagingAnsSorting clusterRepository=context.getBean(ClusterRepositoryUsingPagingAnsSorting.class);
		
		Page<Cluster> clusterPage= clusterRepository.findAll(new PageRequest(1, 3));
		
		System.out.println("Total number of pages :"+clusterPage.getTotalPages());
		System.out.println("Total number of elements in page 2="+clusterPage.getNumberOfElements());
		
		List<Cluster> clusters= clusterPage.getContent();
		
		for(Cluster cluster:clusters){
			System.out.println("Cluster Id :"+cluster.getClusterId());
		}
		
		
		 
	
		
	}
	
	
	

}
