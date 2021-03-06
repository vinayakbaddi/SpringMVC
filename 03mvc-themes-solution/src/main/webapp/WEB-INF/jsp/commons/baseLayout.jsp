<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
	<head>
	    <meta http-equiv="content-type" content="text/html;" charset="UTF-8"/>
	    <title><tiles:insertAttribute name="title"/></title>
	    <meta name="description" content="Way2learn is a  training provider for  technologies such as Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE" />
	    <meta name="keywords" content="Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE, Training in Bangalore" />
	    <meta name="robots" CONTENT="index, follow"/>
		<meta name="revisit-after" CONTENT="1 days"/>
		<meta name="Distribution" content="Global"/>	
		
		
		<c:set var="req" value="${pageContext.request}" />
		<c:set var="url">${req.requestURL}</c:set>
		<c:set var="uri" value="${req.requestURI}" />
				
			 <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
		
		
		<spring:url value="resources" var="resourceUrl" />
		
		<spring:theme var="layoutCSS" code="layout.css"/>
	    
	    
	   
	    
	    <link rel="stylesheet" type="text/css" href="${layoutCSS}">
	    
	    


		
		<link rel="shortcut icon" type="image/x-icon" href="${resourceUrl}/images/favicon.ico" />
	    <link rel="stylesheet" type="text/css" href="${resourceUrl}/css/common.css">
	    
	    <link rel="stylesheet" href="${resourceUrl}/css/fancybox.css" />
	    <link rel="stylesheet" type="text/css" href="${resourceUrl}/css/courses.css">
	    <link rel="stylesheet" type="text/css" href="${resourceUrl}/css/post-common.css">
	    
	    <link rel="stylesheet" type="text/css" href="${resourceUrl}/css/login.css"/> 
	   
	    
	</head>
	
		

	<body>
	
		<div id="wrap" class="container" role="document">
		  	
	        <header id="header" role="banner">
	        	 <tiles:insertAttribute name="topMenu"/>
	        	<c:if test="${applicationScope.offer!=null}">
					<tiles:insertAttribute name="offerBanner"/>
				</c:if>
	        	
	        </header>
        	<tiles:insertAttribute name="body"/>
        <!-- .container -->     
  	 	 </div>
		<!-- /#wrap -->
		<div class="clear"></div>
		<tiles:insertAttribute name="footer"/>
		 
		
				
	</body>
</html>
