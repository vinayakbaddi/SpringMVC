package com.way2learnonline.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Deployment {

	@Id @GeneratedValue
	private Long deploymentId;
	private String deploymentName;
	private String status;
	
	@ManyToMany(mappedBy="deployments",cascade={CascadeType.ALL})	
	private Set<Server> servers;

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

	public Set<Server> getServers() {
		return servers;
	}

	public void setServers(Set<Server> servers) {
		this.servers = servers;
	}
	
	
}
