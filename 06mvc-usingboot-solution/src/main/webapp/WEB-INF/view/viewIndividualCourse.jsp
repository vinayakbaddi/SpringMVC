<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
	<head>
	    <meta http-equiv="content-type" content="text/html;" charset="UTF-8"/>
	    <title>Course Details </title>
	    <meta name="description" content="Way2learn is a  training provider for  technologies such as Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE" />
	    <meta name="keywords" content="Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE, Training in Bangalore" />
	    <meta name="robots" CONTENT="index, follow"/>
		<meta name="revisit-after" CONTENT="1 days"/>
		<meta name="Distribution" content="Global"/>	
		<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
	    <link rel="stylesheet" type="text/css" href="css/common.css">
	    <link rel="stylesheet" type="text/css" href="css/layout.css">
	    <link rel="stylesheet" href="css/fancybox.css" />
	    <link rel="stylesheet" type="text/css" href="css/courses.css">
	    <link rel="stylesheet" type="text/css" href="css/post-common.css">
	    
	    <link rel="stylesheet" type="text/css" href="css/login.css"/> 
	  
	</head>
	<body>

	    <div id="wrap" class="container" role="document">    	
	        <header id="header" role="banner">
	        
	        	   <jsp:include page="topMenu.jsp"/>
	        </header>
	        <div class="app-center t20-p">
	       		 <jsp:include page="viewIndividualCourseBodyLeft.jsp"/>
	       		 <jsp:include page="viewIndividualCourseBodyCenter.jsp"/>
				<jsp:include page="rightSideBody2.jsp"/>
				
				<div class="clear"></div>
			</div>
        	
        <!-- .container -->     
    </div>
		<!-- /#wrap -->
		<div class="clear"></div>
		 <jsp:include page="footer.jsp"/>
		
	</body>
</html>
