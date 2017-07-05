package com.way2learnonline.controllers;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.way2learnonline.dto.ClusterDTO;
import com.way2learnonline.model.Cluster;

	@Component
	public class ClusterResourceAssembler extends ResourceAssemblerSupport<Cluster, ClusterDTO> {
	
		
		public ClusterResourceAssembler() {
			super(ClusterController.class, ClusterDTO.class);	
		}
		
	
		@Override
		public ClusterDTO toResource(Cluster cluster) {
			ClusterDTO clusterDTO=	ClusterDTO.createCluster(cluster);
			
			Link serversLink=ControllerLinkBuilder.linkTo(
					ControllerLinkBuilder.methodOn(ClusterController.class)
										.getAllServers(clusterDTO.getClusterId())
								).withRel("servers");
			
			clusterDTO.add(serversLink);
			
			
			
			return clusterDTO;
		}	
		
		
	}

	