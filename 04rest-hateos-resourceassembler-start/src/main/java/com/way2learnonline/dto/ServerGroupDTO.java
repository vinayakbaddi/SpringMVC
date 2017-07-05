package com.way2learnonline.dto;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.way2learnonline.model.ServerGroup;

public class ServerGroupDTO extends ResourceSupport implements Serializable{

	
	private static final long serialVersionUID = -4587893935145277076L;
	private Long groupId;
	private String groupName;	
	private int serverCount;
	
	public static ServerGroupDTO createServerGroupDTO(ServerGroup serverGroup){
		ServerGroupDTO serverGroupDTO= new ServerGroupDTO();
		return serverGroupDTO;
	}
	
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getServerCount() {
		return serverCount;
	}
	public void setServerCount(int serverCount) {
		this.serverCount = serverCount;
	}
	
	
}
