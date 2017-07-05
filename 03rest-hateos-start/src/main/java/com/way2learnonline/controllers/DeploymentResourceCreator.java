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
		
		// TODO-6 Create a selfLink pointing to DeploymentController.getDeploymentId(deployment.getDeploymentId()) and add it to deploymentDTO
		//TODO-7 create a link with rel servers to DeploymentController.getAllServersByDeploymentId(deployment.getDeploymentId()) and add it to deploymentDTO
		
		
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
