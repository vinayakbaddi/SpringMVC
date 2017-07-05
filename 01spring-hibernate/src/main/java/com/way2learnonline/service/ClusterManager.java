package com.way2learnonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.model.Cluster;
import com.way2learnonline.repository.ClusterRepository;

@Service
public class ClusterManager {
	
	@Autowired private ClusterRepository clusterRepository;
	
	@Transactional
	public void createCluster(Cluster cluster){
		
		cluster=clusterRepository.save(cluster);
		clusterRepository.findAll();
		
	}

}
