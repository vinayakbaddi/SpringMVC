package com.way2learnonline;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.way2learnonline.dto.ClusterDTO;
import com.way2learnonline.dto.ServerDTO;

public class Client {

	public static void main(String[] args) {
		

		RestTemplate restTemplate=  new RestTemplate();
		
		ServerDTO serverDTO= new ServerDTO();
		serverDTO.setServerName("QQQQQQQQQQQQ");
		
		URI locationURI=restTemplate.postForLocation("http://localhost:7070/01rest-basics-solution/servers", serverDTO);
		System.out.println(locationURI);
		
		
		/*ResponseEntity<ClusterDTO> responseEntity=  restTemplate.getForEntity("http://localhost:7070/01rest-basics-solution/clusters/{clusterId}", ClusterDTO.class, 1);
		System.out.println(responseEntity.getHeaders());
		System.out.println(responseEntity.getBody().getClusterName());*/
		//ClusterDTO clusterDTO=restTemplate.getForObject("http://localhost:7070/01rest-basics-solution/clusters/{clusterId}", ClusterDTO.class,1 );
		
		//System.out.println(clusterDTO.getClusterName());
		
		/*ServerDTO serverDTO= new ServerDTO();
		serverDTO.setServerName("AAAAAA");
		*/
		/*URI newIRI= restTemplate.postForLocation("http://localhost:7070/01rest-basics-solution/servers", serverDTO);
		
		System.out.println(newIRI);*/
/*		String url="http://localhost:7070/01rest-basics-solution/servers/{id}";	
				
		ResponseEntity<ServerDTO>  responseEntity= restTemplate.getForEntity(url, ServerDTO.class, 1);
		
		responseEntity.unprocessableEntity()
		
*/		//System.out.println(serverDTO.getServerName());
		
	}

}
