package com.way2learnonline;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Deployment;
import com.way2learnonline.model.Server;
import com.way2learnonline.model.ServerGroup;
import com.way2learnonline.service.ClusterManager;

	@SpringBootApplication
	public class TestDataPopulator {
	
		public static void main(String[] args) {
			
			
			ApplicationContext context= SpringApplication.run(TestDataPopulator.class, args);
			ClusterManager clusterManager=context.getBean(ClusterManager.class);		
			
			Cluster cluster=createCluster();
			
			clusterManager.createCluster(cluster);
			
		}
	
	
	public static Cluster createCluster(){
		ServerGroup firstServerGroup=createServerGroup("First Server Group", 2);
		ServerGroup secondServerGroup=createServerGroup("First Server Group", 3);
		
		Server firstServer= createServer("http://localhost:8081/mmc-support", "192.168.1.2", 2, "First Server", new Date(), "3.7.1");	
		Server secondServer= createServer("http://localhost:8082/mmc-support", "192.168.1.3", 3, "Second Server", new Date(), "3.7.3");
		Server thirdServer= createServer("http://localhost:8083/mmc-support", "192.168.1.4", 2, "Third Server", new Date(), "3.7.4");
		
		firstServerGroup.addServer(firstServer);
		firstServerGroup.addServer(secondServer);
		
		secondServerGroup.addServer(thirdServer);
		
		
		
		Deployment firstDeployment=createDeployment("First Deployment", "Running");
		firstServer.addDeployment(firstDeployment);
		secondServer.addDeployment(firstDeployment);
		Deployment secondDeployment=createDeployment("First Deployment", "Running");
		
		thirdServer.addDeployment(secondDeployment);	
		
		
			
		
		Cluster  cluster= new Cluster();
		cluster.setClusterName("First Cluster");
		cluster.setClusterStatus("2 of  Nodes Running");
		cluster.setRunningServices(5);
		cluster.addServer(firstServer);
		cluster.addServer(secondServer);
		cluster.addServer(thirdServer);
		
		return cluster;
		
	}
	
	
	
	public static Server createServer(String serverAgentUrl,String hostIp,int runningServices,String serverName,Date started,String version){
		Server server= new Server();
		server.setAgentUrl(serverAgentUrl);
		server.setHostIp(hostIp);
		server.setRunningServices(runningServices);
		server.setServerName(serverName);
		server.setStarted(started);
		server.setVersion(version);
		
		return server;
	}
	
	public static ServerGroup createServerGroup(String groupName,int serverCount){
		ServerGroup serverGroup= new ServerGroup();
		serverGroup.setGroupName(groupName);
		serverGroup.setServerCount(serverCount);		
		return serverGroup;
		
	}
	
	public static Deployment createDeployment(String deploymentName,String status){
		Deployment deployment= new Deployment();
		deployment.setDeploymentName(deploymentName);
		deployment.setStatus(status);
		
		return deployment;
	}

}
