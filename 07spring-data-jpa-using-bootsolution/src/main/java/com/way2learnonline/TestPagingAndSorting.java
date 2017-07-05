package com.way2learnonline;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.way2learnonline.model.Cluster;
import com.way2learnonline.repository.ClusterRepositoryUsingPagingAnsSorting;

@SpringBootApplication
public class TestPagingAndSorting {

public static void main(String[] args) {
		
		
		ApplicationContext context= new AnnotationConfigApplicationContext(TestPagingAndSorting.class);
		
		ClusterRepositoryUsingPagingAnsSorting clusterRepository=
				context.getBean(ClusterRepositoryUsingPagingAnsSorting.class);
		
		
		PageRequest pageRequest= new PageRequest(1, 4, Direction.DESC, "clusterId");
		
		
		
		Page<Cluster> pageOfCluster=clusterRepository.findAll(pageRequest);
		List<Cluster> clusters= pageOfCluster.getContent();	
		
		for(Cluster cluster:clusters){
			System.out.println("cluster id : "+cluster.getClusterId());
		}
		
		
		
		 
	
		
	}
	
	
	

}
