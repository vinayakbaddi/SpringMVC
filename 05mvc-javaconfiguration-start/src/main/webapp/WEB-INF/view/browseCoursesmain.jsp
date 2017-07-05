<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
	<head>
	    <meta http-equiv="content-type" content="text/html;" charset="UTF-8"/>
	    <title>Browse Courses</title>
	    <meta name="description" content="Way2learn is a  training provider for  technologies such as Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE" />
	    <meta name="keywords" content="Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE, Training in Bangalore" />
	    <meta name="robots" CONTENT="index, follow"/>
		<meta name="revisit-after" CONTENT="1 days"/>
		<meta name="Distribution" content="Global"/>	
		<link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.ico" />
	    <link rel="stylesheet" type="text/css" href="resources/css/common.css">
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
	        
	        <div class="app-center">
		        <div class="course-main">
			         <jsp:include page="myCoursesFraction.jsp"/>
			        <jsp:include page="browseCoursesFraction.jsp"/>
		        </div>
		         <jsp:include page="rightSideBody3.jsp"/>
	        </div>
	       
	   
</div>
        	
  
		<!-- /#wrap -->
		<div class="clear"></div>
		 <jsp:include page="footer.jsp"/>
		
	</body>
</html>
