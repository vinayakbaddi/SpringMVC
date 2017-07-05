package com.way2learnonline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.way2learnonline.dto.DeploymentDTO;
import com.way2learnonline.model.Deployment;

@Component
public class DeploymentResourceAssembler extends ResourceAssemblerSupport<Deployment, DeploymentDTO> {
	
	
	public DeploymentResourceAssembler() {
		super(DeploymentController.class, DeploymentDTO.class);
	}




	@Override
	public DeploymentDTO toResource(Deployment deployment) {

		DeploymentDTO deploymentDTO= DeploymentDTO.createDeploymentDTO(deployment);
		
		
		Link serversLink=
				ControllerLinkBuilder.linkTo(
						ControllerLinkBuilder.methodOn(DeploymentController.class).getAllServersByDeploymentId(deployment.getDeploymentId())).withRel("servers");
		
		deploymentDTO.add(serversLink);
		return deploymentDTO;
	}
}
