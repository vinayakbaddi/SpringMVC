package com.way2learnonline;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Deployment;
import com.way2learnonline.model.Server;
import com.way2learnonline.model.ServerGroup;
import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.DeploymentRepository;
import com.way2learnonline.repository.ServerGroupRepository;
import com.way2learnonline.repository.ServerRepository;

@SpringBootApplication
public class TestDataPopulator {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TestDataPopulator.class, args);
		ClusterRepository clusterRepository=context.getBean(ClusterRepository.class);
		
		/*ServerRepository serverRepository=context.getBean(ServerRepository.class);
		ServerGroupRepository serverGroup=context.getBean(ServerGroupRepository.class);
		DeploymentRepository deploymentRepository=context.getBean(DeploymentRepository.class);*/
		
		
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
		
		
		clusterRepository.save(cluster);
		
		Iterable<Cluster> clusters=  clusterRepository.findAll();
		
		for(Cluster cluster2:clusters){
			System.out.println(cluster2.getClusterName());
		}

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
