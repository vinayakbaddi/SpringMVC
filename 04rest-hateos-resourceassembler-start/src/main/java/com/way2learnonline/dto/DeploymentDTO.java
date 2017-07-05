package com.way2learnonline.dto;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.way2learnonline.model.Deployment;

public class DeploymentDTO extends ResourceSupport implements Serializable{
	
	private static final long serialVersionUID = 5763300421460810909L;
	private Long deploymentId;
	private String deploymentName;
	private String status;
	
	
	public static DeploymentDTO createDeploymentDTO(Deployment deployment){
		DeploymentDTO deploymentDTO= new DeploymentDTO();
		deploymentDTO.setDeploymentId(deployment.getDeploymentId());
		deploymentDTO.setDeploymentName(deployment.getDeploymentName());
		deploymentDTO.setStatus(deployment.getStatus());
		return deploymentDTO;
	}
	
	
	public Long getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(Long deploymentId) {
		this.deploymentId = deploymentId;
	}
	public String getDeploymentName() {
		return deploymentName;
	}
	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
