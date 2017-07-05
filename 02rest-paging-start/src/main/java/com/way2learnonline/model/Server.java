package com.way2learnonline.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Server {
	@Id
	@GeneratedValue
	private Long serverId;
	private String serverName;
	private String version;
	private String hostIp;
	private Date started ;
	private int runningServices;	
	private String agentUrl;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="CLUSTER_ID")
	private Cluster cluster;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="SERVER_GROUP_ID")
	private ServerGroup serverGroup;
	
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinTable(name="SERVER_DEPLOYMENTS",joinColumns={@JoinColumn(name="SERVER_ID")},inverseJoinColumns={@JoinColumn(name="DEPLOYMENT_ID")})
	private Set<Deployment> deployments;
	
	
	
	public void addDeployment(Deployment deployment){
		
		Set<Server> servers=deployment.getServers();
		if(deployments==null){
			deployments= new HashSet<Deployment>();
		}
		if(servers==null){
			servers= new HashSet<Server>();
		}
	
		
		servers.add(this);
		deployments.add(deployment);
		
	}
	
	
	
	public Set<Deployment> getDeployments() {
		return deployments;
	}
	public void setDeployments(Set<Deployment> deployments) {
		this.deployments = deployments;
	}
	public Long getServerId() {
		return serverId;
	}
	public void setServerId(Long serverId) {
		this.serverId = serverId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public Date getStarted() {
		return started;
	}
	public void setStarted(Date started) {
		this.started = started;
	}
	public int getRunningServices() {
		return runningServices;
	}
	public void setRunningServices(int runningServices) {
		this.runningServices = runningServices;
	}
	public String getAgentUrl() {
		return agentUrl;
	}
	public void setAgentUrl(String agentUrl) {
		this.agentUrl = agentUrl;
	}
	public Cluster getCluster() {
		return cluster;
	}
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
	public ServerGroup getServerGroup() {
		return serverGroup;
	}
	public void setServerGroup(ServerGroup serverGroup) {
		this.serverGroup = serverGroup;
	}

	
	
	
	

}
