package com.way2learnonline.repository;

import org.springframework.data.repository.RepositoryDefinition;

import com.way2learnonline.model.Cluster;

	@RepositoryDefinition(domainClass=Cluster.class,idClass=Long.class)
	public interface CustomClusterRepository {
	
		Cluster save(Cluster entity);	
		Cluster findOne(Long id);	 
		Iterable<Cluster> findAll();
		long count();	
		void delete(Long id);
	
		
	}

	
	