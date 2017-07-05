package com.way2learnonline.dto;

import java.io.Serializable;

import com.way2learnonline.model.Cluster;

public class ClusterDTO implements Serializable {

	private Long clusterId;
	private String clusterName;	
	private String clusterStatus; //
	private int runningServices;
	
	
	
	public Cluster createCluster(){
		Cluster cluster= new Cluster();
		cluster.setClusterId(this.getClusterId());
		cluster.setClusterName(this.getClusterName());
		cluster.setClusterStatus(this.getClusterStatus());
		cluster.setRunningServices(this.getRunningServices());
		
		return cluster;
	}
	
	public static ClusterDTO createCluster(Cluster cluster){
		ClusterDTO clusterDTO= new ClusterDTO();
		clusterDTO.setClusterId(cluster.getClusterId());
		clusterDTO.setClusterName(cluster.getClusterName());
		clusterDTO.setClusterStatus(cluster.getClusterStatus());
		clusterDTO.setRunningServices(cluster.getRunningServices());
		return clusterDTO;
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
	
	
}
