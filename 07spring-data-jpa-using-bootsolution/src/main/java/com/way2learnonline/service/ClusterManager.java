package com.way2learnonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Server;
import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.ServerRepository;

@Service
public class ClusterManager {
	
	@Autowired private ClusterRepository clusterRepository;
	
	@Autowired private ServerRepository  serverRepository;
	
	@Transactional
	public void createCluster(Cluster cluster){
		cluster=clusterRepository.save(cluster);		
	}
	
	@Transactional
	public void createServer(Server server){
	serverRepository.save(server);	
	}

}
