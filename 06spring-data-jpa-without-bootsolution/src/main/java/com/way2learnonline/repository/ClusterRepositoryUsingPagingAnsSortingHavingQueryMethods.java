package com.way2learnonline.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.way2learnonline.model.Cluster;

	public interface ClusterRepositoryUsingPagingAnsSortingHavingQueryMethods 
			extends PagingAndSortingRepository<Cluster, Long> {
	
		
		public List<Cluster> findByClusterName(String clusterName);
		public List<Cluster> findByClusterNameOrClusterStatus(String clusterName,String clusterStatus);
		public List<Cluster> findByClusterNameEndingWith(String clusterName);
		public List<Cluster> findByClusterNameContains(String clusterName);
		public List<Cluster> findByClusterNameIgnoreCase(String clusterName);
		
	}


	
	