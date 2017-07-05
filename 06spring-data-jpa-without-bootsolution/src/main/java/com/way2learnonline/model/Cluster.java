package com.way2learnonline.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cluster {
	@Id @GeneratedValue
	private Long clusterId;
	private String clusterName;	
	private String clusterStatus; //
	private int runningServices;
	
	@OneToMany(cascade={CascadeType.ALL},mappedBy="cluster",fetch=FetchType.LAZY)	
	private Set<Server> servers;
	
	
	public void addServer(Server server){
		if(servers==null){
			servers= new HashSet<Server>();
		}
		
		servers.add(server);
		server.setCluster(this);
	}
	
	
	

	public Long getClusterId() {
		return clusterId;
	}

	public void setClusterId(Long clusterId) {
		this.clusterId = clusterId;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getClusterStatus() {
		return clusterStatus;
	}

	public void setClusterStatus(String clusterStatus) {
		this.clusterStatus = clusterStatus;
	}

	public int getRunningServices() {
		return runningServices;
	}

	public void setRunningServices(int runningServices) {
		this.runningServices = runningServices;
	}

	public Set<Server> getServers() {
		return servers;
	}

	public void setServers(Set<Server> servers) {
		this.servers = servers;
	}
	
	
	
	

}
