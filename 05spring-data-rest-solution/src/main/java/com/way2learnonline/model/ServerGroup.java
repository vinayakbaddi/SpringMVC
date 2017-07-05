package com.way2learnonline.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ServerGroup {
	
	@Id @GeneratedValue
	private Long groupId;
	private String groupName;	
	private int serverCount;
	
	@OneToMany(mappedBy="serverGroup",cascade=CascadeType.ALL)	
	private Set<Server> servers;	
	
	
	public void addServer(Server server){
		if(servers==null){
			servers= new HashSet<Server>();
		}
		
		servers.add(server);
		server.setServerGroup(this);
	}
	
	
	public Set<Server> getServers() {
		return servers;
	}
	public void setServers(Set<Server> servers) {
		this.servers = servers;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public int getServerCount() {
		return serverCount;
	}
	public void setServerCount(int serverCount) {
		this.serverCount = serverCount;
	}
	
	
	

}
