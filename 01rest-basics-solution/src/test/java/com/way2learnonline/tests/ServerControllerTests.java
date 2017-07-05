package com.way2learnonline.tests;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.way2learnonline.RestConfig;
import com.way2learnonline.dto.ServerDTO;
import com.way2learnonline.model.Server;
import com.way2learnonline.repository.ServerRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RestConfig.class,TestConfig.class})
@WebAppConfiguration
public class ServerControllerTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private ServerRepository serverRepository;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp(){		
		Mockito.reset(serverRepository);		
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();	
		
		ServerDTO firstServer= createServerDTO("http://localhost:8081/mmc-support", "192.168.1.2", 2, "First Server", new Date(), "3.7.1");	
		ServerDTO secondServer= createServerDTO("http://localhost:8082/mmc-support", "192.168.1.3", 3, "Second Server", new Date(), "3.7.3");
		ServerDTO thirdServer= createServerDTO("http://localhost:8083/mmc-support", "192.168.1.4", 2, "Third Server", new Date(), "3.7.4");
		
		List<ServerDTO> serverDTOs=Arrays.asList(firstServer,secondServer,thirdServer);
	
		
		
	}
	
	
	
	
	

	public static ServerDTO createServerDTO(String serverAgentUrl,String hostIp,int runningServices,String serverName,Date started,String version){
		ServerDTO server= new ServerDTO();
		server.setAgentUrl(serverAgentUrl);
		server.setHostIp(hostIp);
		server.setRunningServices(runningServices);
		server.setServerName(serverName);
		server.setStarted(started);
		server.setVersion(version);
		
		return server;
	}

}
