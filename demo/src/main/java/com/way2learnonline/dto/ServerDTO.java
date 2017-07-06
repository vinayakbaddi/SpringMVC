package com.way2learnonline.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.way2learnonline.model.Server;

@XmlRootElement(name="server")
public class ServerDTO {

	private Long serverId;
	private String serverName;
	private String version;
	private String hostIp;
	private Date started ;
	private int runningServices;	
	private String agentUrl;
	
	
	public Server createServer(){
		Server server= new Server();
		server.setAgentUrl(agentUrl);
		server.setHostIp(hostIp);
		server.setRunningServices(runningServices);
		server.setServerId(serverId);
		server.setServerName(serverName);
		server.setStarted(started);
		server.setVersion(version);
		return server;
	}
	
	
	public static ServerDTO createServerDTO(Server server){
		ServerDTO serverDTO= new ServerDTO();
		serverDTO.setAgentUrl(server.getAgentUrl());
		serverDTO.setHostIp(server.getHostIp());
		serverDTO.setRunningServices(server.getRunningServices());
		serverDTO.setServerId(server.getServerId());
		serverDTO.setServerName(server.getServerName());
		serverDTO.setStarted(server.getStarted());
		serverDTO.setVersion(server.getVersion());
		return serverDTO;
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
	
	
}
