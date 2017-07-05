<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
	<head>
	    <meta http-equiv="content-type" content="text/html;" charset="UTF-8"/>
	    <title>Way2Learn for Free</title>
	    <meta name="description" content="Way2learn is a  training provider for  technologies such as Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE" />
	    <meta name="keywords" content="Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE, Training in Bangalore" />
	    <meta name="robots" CONTENT="index, follow"/>
		<meta name="revisit-after" CONTENT="1 days"/>
		<meta name="Distribution" content="Global"/>	
		
		<c:set var="req" value="${pageContext.request}" />
		<c:set var="url">${req.requestURL}</c:set>
		<c:set var="uri" value="${req.requestURI}" />
				
			 <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
		
		
		
		
		<link rel="stylesheet" type="text/css" href="resources/css/common.css"  >	
		
			
		<link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.ico" />
		
		
	    
	    <link rel="stylesheet" type="text/css" href="resources/css/layout.css">
	    <link rel="stylesheet" href="resources/css/fancybox.css" />
	    <link rel="stylesheet" type="text/css" href="resources/css/courses.css">
	    <link rel="stylesheet" type="text/css" href="resources/css/post-common.css">
	    
	    <link rel="stylesheet" type="text/css" href="resources/css/login.css"/> 
	   
	</head>
	<body>		
	    <div id="wrap" class="container" role="document">    	
	        <header id="header" role="banner">	        
	        	   <jsp:include page="topMenu.jsp"/>
	        </header>
	        <jsp:include page="body.jsp"/>
    
    </div>
		<!-- /#wrap -->
		<div class="clear"></div>
		 <jsp:include page="footer.jsp"/>
		
	</body>
</html>
