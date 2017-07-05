package com.way2learnonline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.way2learnonline.dto.ServerDTO;
import com.way2learnonline.model.Server;

@Component
public class ServerResourceAssembler extends ResourceAssemblerSupport<Server, ServerDTO> {
	
	
	public ServerResourceAssembler() {
		super(ServerController.class,ServerDTO.class);
	}
	
	public   ServerDTO toResource(Server server){
		
		ServerDTO serverDTO= ServerDTO.createServerDTO(server);
		
			
		Link clusterLink=ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(ClusterController.class).getClusterById(server.getCluster().getClusterId())).withRel("cluster");
		
		serverDTO.add(clusterLink);
		
		Link deploymentsLink=ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(ServerController.class).getAllDeploymentsOnServerById(serverDTO.getServerId())).withRel("deployments");
		
		serverDTO.add(deploymentsLink);
		
		return serverDTO;
		
	}
	
	

}
