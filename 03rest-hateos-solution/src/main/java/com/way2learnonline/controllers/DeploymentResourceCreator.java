package com.way2learnonline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.way2learnonline.dto.DeploymentDTO;
import com.way2learnonline.model.Deployment;

public class DeploymentResourceCreator {

	public static  DeploymentDTO toResource(Deployment deployment){
		
		DeploymentDTO deploymentDTO= DeploymentDTO.createDeploymentDTO(deployment);
		
		Link selfLink=
				ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DeploymentController.class).getDeploymentById(deployment.getDeploymentId())).withSelfRel();
		
		deploymentDTO.add(selfLink);
		
		Link serversLink=
				ControllerLinkBuilder.linkTo(
						ControllerLinkBuilder.methodOn(DeploymentController.class).getAllServersByDeploymentId(deployment.getDeploymentId())).withRel("servers");
		
		deploymentDTO.add(serversLink);
		return deploymentDTO;
		
	}
	
	
	public static List<DeploymentDTO> toResources(Iterable<Deployment> deployments){
		
		List<DeploymentDTO> deploymentDTOs= new ArrayList<DeploymentDTO>();
		
		for(Deployment deployment:deployments){
			deploymentDTOs.add(toResource(deployment));
		}
		return deploymentDTOs;
	}
}
