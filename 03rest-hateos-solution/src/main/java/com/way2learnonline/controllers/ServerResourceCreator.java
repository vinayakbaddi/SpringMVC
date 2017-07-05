package com.way2learnonline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.way2learnonline.dto.ServerDTO;
import com.way2learnonline.model.Server;

public class ServerResourceCreator {
	
	
	public static  ServerDTO toResource(Server server){
		
		ServerDTO serverDTO= ServerDTO.createServerDTO(server);
		
		Link selfLink=ControllerLinkBuilder.linkTo(		
		ControllerLinkBuilder.methodOn(ServerController.class).getServerById(server.getServerId())
		).withSelfRel();
		
		
		Link cluster=
				ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ClusterController.class).getClusterById(server.getCluster().getClusterId())).withRel("cluster");
		
		Link deploymentsLink=ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(ServerController.class).getAllDeploymentsOnServerById(server.getServerId())).withRel("deployments");
		
		serverDTO.add(selfLink);
		serverDTO.add(cluster);
		
		serverDTO.add(deploymentsLink);
		
		
		
		
			/*Link selfLink=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ServerController.class).getServerById(serverDTO.getServerId())).withSelfRel();
		serverDTO.add(selfLink);
		
		Link clusterLink=ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(ClusterController.class).getClusterById(server.getCluster().getClusterId())).withRel("cluster");
		
		serverDTO.add(clusterLink);
		
		Link deploymentsLink=ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(ServerController.class).getAllDeploymentsOnServerById(serverDTO.getServerId())).withRel("deployments");
		
		serverDTO.add(deploymentsLink);*/
		
		return serverDTO;
		
	}
	
	public static List<ServerDTO> toResources(Iterable<Server> servers){
		
		List<ServerDTO> serverDTOs= new ArrayList<ServerDTO>();
		
		for(Server server:servers){
			serverDTOs.add(toResource(server));
		}
		
		return serverDTOs;
		
	}
	

}
