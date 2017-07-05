<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="course-features" id="CourseFeature">
	<ul class="course-features">     
		 <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;All Presentations Download</li>
           <p>
	           	<span>
	           	<c:if test="${SPRING_SECURITY_CONTEXT!=null}">
	           		Download the password protected Presentations here :
	          		<a href="http://resources.way2learn.co.in/soap/presentations-pdf.zip" > Presentations  </a><br/><br/>
	           	</c:if>
	           	
	           	<c:if test="${SPRING_SECURITY_CONTEXT==null}">
						Please <a   href="javascript:signIn()"  style="color: blue; text-decoration: underline;" >SIGN IN</a> to  Download the Presentations
				</c:if>  		
	          		
	           	</span>
           </p>   
           
            <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;All Lab Documentation Download</li>
           <p>
	           	<span>
	           		<c:if test="${SPRING_SECURITY_CONTEXT!=null}">
		          		Download the password protected Lab Documents here :
		          		<a href="http://resources.way2learn.co.in/soap/labinstructions-pdf.zip" > Lab Exercise Documentation  </a><br/><br/>
	          		</c:if>
	          		<c:if test="${SPRING_SECURITY_CONTEXT==null}">
						Please <a   href="javascript:signIn()"  style="color: blue; text-decoration: underline;" >SIGN IN</a> to  Download the Lab Documentation
					</c:if>
	           	</span>
           </p>  
           
            <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;All Lab Code Download</li>
           <p>
	           	<span>
	          		Download the Lab Code  here :
	          		<a href="http://resources.way2learn.co.in/soap/soapwebservicesws.zip" > Lab Code  </a><br/><br/>
	          		
	           	</span>
           </p>   
            
           
                           
         <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Overview of the Soap Webservice Tutorial Series</li>
           <p>
	           	<span>
	          		This course will teach you Soap Webservices  starting from basics to advanced Level.
	          		All you have to do is to see the video for each module, work on the lab exercises.<br/>
	          		
	           	</span>
           </p>
               
         <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; XSD Basics</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/02XSD.exe">Video </a><br/>
					
			   </span>
		   </p>
               
         <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;JAXB </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/03Jaxb-part1.exe" >JAXB Video -Part1</a><br/>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/02Jaxb-part2.exe" >JAXB Video -Part2</a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Remote Method Invocation using Java RMI</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/05RMI.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Introduction to SOAP Webservices</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/06IntrotoSoapWebservices.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; SAAJ </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/07SAAJ.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;WSDL  in detail</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/08WsdlIndetail.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Contract First Webservice </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/09ContractFirstWebservice.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;UnWrapped Webservice </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/10UnwrappedService.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;RPC Style Vs Document Style Webservices </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/11RPCVSDocument.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		   <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Writing Asynchronous Client   </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/12AsynchClient.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		   <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Sending Binary Content  </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/13SendingBinaryData.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Handling Exceptions </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/14HandlingExceptions.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; JAX-Ws Handlers </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/15JaxwsHandlers.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Ws- Addressing </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/16-Ws-Addressing.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;   Apache CXF Introduction  </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/20-CXF-Intro-NonWebapp.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Deploying Webservice inside Web App using CXF and Spring </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/21CXF-Webappdeployment-using-spring.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Using JMS as transport protocol </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/22CXF-JMS-transport.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Introduction to WS-Security and Using UserName Token</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/23Ws-Security-Usernametoken.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Security Concepts- Encryption,Signature,Certificate ,etc</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/24SecurityConcepts.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
           
             <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Ws-Security Signing using CXF</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/25SignatureinCXF.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
           
             <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Ws-Security Encrytion using CXF</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/soap/videos/26EncryptionCXF.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		  
      		
	</ul>
</div>