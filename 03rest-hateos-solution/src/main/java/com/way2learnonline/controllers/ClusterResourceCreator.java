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
		
		ClusterController clusterController=ControllerLinkBuilder.methodOn(ClusterController.class);
		ClusterDTO clusterDTO2=clusterController.getClusterById(cluster.getClusterId());
		
		Link selfLink=ControllerLinkBuilder.linkTo(clusterDTO2).withSelfRel();
		
		clusterDTO.add(selfLink);
		
		Link serversLink=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ClusterController.class).getAllServers(cluster.getClusterId())).withRel("servers");
		
		clusterDTO.add(serversLink);
		
			return clusterDTO;
	}
	
	
	public static List<ClusterDTO> toResources(Iterable<Cluster> clusters){
		List<ClusterDTO> clusterDTOs= new ArrayList<ClusterDTO>();
		
		for(Cluster cluster:clusters){
			clusterDTOs.add(toResource(cluster));
		}
		
		return clusterDTOs;
	}
	
}
