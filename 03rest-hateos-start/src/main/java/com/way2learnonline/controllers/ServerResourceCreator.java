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
		
		// TODO-8 Create a selfLink pointing to ServerController.getServerById(serverDTO.getServerId()) and add it to serverDTO
		//TODO-9 create a link with rel cluster to ClusterController.getClusterById(server.getCluster().getClusterId()) and add it to serverDTO
		// TODO-10 create a link with rel deployments to ServerController.getAllDeploymentsOnServerById(serverDTO.getServerId()) and add it to serverDTO
				
		
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
