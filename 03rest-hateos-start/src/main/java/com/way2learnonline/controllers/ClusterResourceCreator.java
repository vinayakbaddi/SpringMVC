package com.way2learnonline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.way2learnonline.dto.ClusterDTO;
import com.way2learnonline.model.Cluster;

public class ClusterResourceCreator {

	
	public static ClusterDTO toResource(Cluster cluster){
		
		ClusterDTO clusterDTO=ClusterDTO.createCluster(cluster);	
		
		
	
		//TODO-1 initialize below self link with a link to getClusterById on ClusterController as described in this lab documentatiom
		
		
		Link selfLink=null;
		// TODO -2 add this selfLink to clusterDTO
		
		// TODO-3 initialize below serversLink to getAllServers on ClusterController as described in this lab documentations
			
		Link serversLink=null;
		//TODO-4 add this serversLink to clusterDTO
			
			
			return clusterDTO;
	}
	
	
	public static List<ClusterDTO> toResources(Iterable<Cluster> clusters){
		
		// TODO-5 Understand the below Code
		
		List<ClusterDTO> clusterDTOs= new ArrayList<ClusterDTO>();
		
		for(Cluster cluster:clusters){
			clusterDTOs.add(toResource(cluster));
		}		
		return clusterDTOs;
	}
	
}
