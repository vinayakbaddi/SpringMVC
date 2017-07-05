package com.way2learnonline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.way2learnonline.model.Cluster;
import com.way2learnonline.repository.ClusterRepositoryUsingPagingAnsSorting;

public class TestSorting {

public static void main(String[] args) {
		
		
		ApplicationContext context= new AnnotationConfigApplicationContext(JpaConfig.class);
		
		ClusterRepositoryUsingPagingAnsSorting clusterRepository=
				context.getBean(ClusterRepositoryUsingPagingAnsSorting.class);
		
		Sort sort= new Sort(Direction.DESC, "clusterId");
		
		Iterable<Cluster> clusters=clusterRepository.findAll(sort);
		
		for(Cluster c:clusters){
			System.out.println("Cluster Id : "+c.getClusterId());
		}
		
		
		 
	
		
	}
	
	
	

}
