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
import com.way2learnonline.repository.ClusterRepositoryUsingPagingAnsSortingHavingQueryMethods;
@SpringBootApplication
public class TestPagingAndSortingHavingQueryMethods {

public static void main(String[] args) {
		
		
	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(TestPagingAndSortingHavingQueryMethods.class);
		
		ClusterRepositoryUsingPagingAnsSortingHavingQueryMethods clusterRepository=
				context.getBean(ClusterRepositoryUsingPagingAnsSortingHavingQueryMethods.class);
		
		List<Cluster> clusters= clusterRepository.findByClusterNameEndingWith("Siva");
		
		for(Cluster cluster:clusters){			
			System.out.println(cluster.getClusterName());
		}
		
		clusters = clusterRepository.findByClusterNameOrClusterStatus("First Cluster", "2 of  Nodes Running");
		
		for(Cluster cluster:clusters){
			
			System.out.println(cluster.getClusterName() +"   "+cluster.getClusterStatus());
		}
		
		context.close();
		
	}
	
	
	

}
