package com.way2learnonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.way2learnonline.model.Cluster;

	public interface ClusterRepositoryUsingPagingAnsSorting 
			extends PagingAndSortingRepository<Cluster, Long> {
	
	}


	