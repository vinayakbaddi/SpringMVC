<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
	<head>
	    <meta http-equiv="content-type" content="text/html;" charset="UTF-8"/>
	    <title><tiles:insertAttribute name="title"/></title>
	    <meta name="description" content="Way2learn is a  training provider for  technologies such as Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE" />
	    <meta name="keywords" content="Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE, Training in Bangalore" />
	    <meta name="robots" CONTENT="index, follow"/>
		<meta name="revisit-after" CONTENT="1 days"/>
		<meta name="Distribution" content="Global"/>	
		<link rel="shortcut icon" type="image/x-icon" href="${applicationScope.resourcePath}/images/favicon.ico" />
	    <link rel="stylesheet" type="text/css" href="${applicationScope.resourcePath}/css/common.css">
	    <link rel="stylesheet" type="text/css" href="${applicationScope.resourcePath}/css/layout.css">
	    <link rel="stylesheet" href="${applicationScope.resourcePath}/css/fancybox.css" />
	    <link rel="stylesheet" type="text/css" href="${applicationScope.resourcePath}/css/courses.css">
	    <link rel="stylesheet" type="text/css" href="${applicationScope.resourcePath}/css/post-common.css">
	    
	    <link rel="stylesheet" type="text/css" href="${applicationScope.resourcePath}/css/login.css"/> 
	    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	    <!--[if lt IE 9]>
	      <script src="js/html5shiv.js"></script>
	    <![endif]-->
	    <c:if test="${sessionScope.userDetails!=null}">
	    	<script type="text/javascript">
	    		parent.$.fancybox.close();
		    </script>
	    </c:if>
	</head>
	<body>
		<script type="text/javascript">
			xmlhttp=null;
			try {
				xmlhttp=new XMLHttpRequest();
			} catch (e) {
				try {
					xmlhttp=new AciveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser doesn't support AJAX");
				}
			}
		</script>
		<script type="text/javascript">
			var y;
			function getMachineIdInput(x,a){
				y=x;
				if(a!=null){
					document.getElementById("machineIdFirst"+a).innerHTML="<div id='machineIdFirst'><input type='text' name='machineId' id='machineId' placeholder='Machine Id'/>&nbsp;&nbsp;<a class='btn btn-green btn-login' onclick='uploadMachineId(this)'  title='"+x.title+"'>Upload</a></div>";
				}else{
					document.getElementById("machineIdFirst").innerHTML="<div id='machineIdFirst'><input type='text' name='machineId' id='machineId' placeholder='Machine Id'/>&nbsp;&nbsp;<a class='btn btn-green btn-login' onclick='uploadMachineId(this)'  title='"+x.title+"'>Upload</a></div>";
				}
				
			}
			
			function uploadMachineId(x){
				y=x
				var machineId=document.getElementById("machineId").value;
				if(machineId.length!=0){
					xmlhttp.open("GET","${applicationScope.resourcePath}/../s/updateMachineId.htm?machineId="+machineId+"&courseId="+x.title,true);
					xmlhttp.onreadystatechange=updateMachineId;
					xmlhttp.send(null);
				}else{
					alert("Please enter machine id to continue..!");
				}
			}
			function updateMachineId(){
				if(xmlhttp.readyState==4){
					result=xmlhttp.responseText;
					if(result="true"){
						document.getElementById("machineIdFirst").innerHTML="<b style='color : green;'>Machine Id is uploaded successfully. You will get machine secrete in 24 Hours</b>";
					}else if(result=="false"){
						document.getElementById("machineIdFirst").innerHTML=
							"<div id='machineIdFirst'>"
								+"<b style='color : red;'>Machine Id upload falied</b> <input type='text' name='machineId' id='machineId' placeholder='Machine Id'/>&nbsp;&nbsp;"
								+"<a class='btn btn-green btn-login' onclick='uploadMachineId(this)'  title='"+y.title+"'>Upload</a>"
							+"</div>";
					}else{
						document.getElementById("machineIdFirst").innerHTML="<b style='color:red;'>Please SignIn to upload machine id</b>";
					}
				}
			}
		</script>
		<!-- <script type="text/javascript">
			function addToCart(courseId){
				xmlhttp.open("GET","addToCart.htm?courseId="+courseId,true);
				xmlhttp.onreadystatechange=update;
				xmlhttp.send(null);
			}
			function update() {
				if(xmlhttp.readyState==4){
					var result=xmlhttp.responseText;
					document.getElementById("cartSize").innerHTML=="";
					if(result=="This Course is already added to cart"){
						alert(result);
					}else{
						document.getElementById("cartSize").innerHTML=xmlhttp.responseText;
					}
				}
			}
		</script> -->
	    <div id="wrap" class="container" role="document">    	
	        <header id="header" role="banner">
	        	<c:if test='${sessionScope.browserCompatabilty=="No"}'>
					<c:import url="browserCompatibility.jsp"/>
				</c:if>
	        	
	        	<tiles:insertAttribute name="topMenu"/>
	        </header>
        	<tiles:insertAttribute name="body"/>
        <!-- .container -->     
    </div>
		<!-- /#wrap -->
		<div class="clear"></div>
		<tiles:insertAttribute name="footer"/>
		<script type="text/javascript" src="${applicationScope.resourcePath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${applicationScope.resourcePath}/js/jquery.sticky.js"></script>
		<script type="text/javascript" src="${applicationScope.resourcePath}/js/jquery.fancybox.js"></script>
		<script type="text/javascript" src="${applicationScope.resourcePath}/js/jquery.slider.js"></script>
		<script type="text/javascript" src="${applicationScope.resourcePath}/js/jquery-dropdown.js"></script>
		<script type="text/javascript">
			$(window).load(function() {
				$("#headerSticky").sticky({topSpacing : 0, className : "sticked"});
				$("#navSticky").sticky({ topSpacing: 120, className: "fixedmenu-vertical-sticked" });
				$("#rightSideBody").sticky({ topSpacing: 90, className: "fixedmenu-vertical-sticked" });
				$("#referFriendsRightDiv").sticky({ topSpacing: 120, className: "fixedmenu-vertical-sticked" });
			});
			$(document).ready(function() {
				$('#testimonials').bjqs({
					animtype : 'slide',
					height : 120,
					width : 320,
					showmarkers : false
				});
				$("#Support").click( function(){
					$.popbox({
						'width': 550,
						'height': 330,
						'autoScale': false,
						'type': 'iframe',
						'href': 'support.html'
					});			
				});	
				$("#faqList li").click(function(){
					if ($(this).hasClass('active')) {
						$(this).removeClass('active'); 
					}else{
						$(this).addClass('active');
					}
				});
				var GPTab = "linkTab1";
				var GCTab = "contentTab1";
				$(".main-tabs a").live("click", function(){
					var s = $(this).attr('id'), res = s.split("Tab"), parent = "linkTab"+res[1], content="contentTab"+res[1];
					if (GPTab != parent) {
						if (GCTab != "") {
							$('#' + GCTab).hide();
							$('#' + parent).removeClass('active');
							$('#' + GPTab).removeClass('active');
						}
						$('#' + content).show();
						$('#' + parent).addClass('active');
						GCTab = content;
						GPTab = parent;	
					} 
				});
				$('#viewedCourses').bjqs({
					animtype : 'slide',
					height : 120,
					width : 730,
					showmarkers : false
				});
				$(".course-features li").click(function() {
					if ($(this).next(".course-features p").is(":hidden")) {
						$(this).next(".course-features p").slideDown("slow");
						$(this).css({"color":"#ffc100"});
						$(this).children(".course-features i").html('-');
					} else {
					   $(this).css({"color":"rgb(68, 68, 68)"});
						$(this).next(".course-features p").slideUp("slow");
						$(this).children(".course-features i").html('+');
					}
				});
			});
			/* $("#signInLink").live("click", function() {
				var location1=window.location.href;
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : 's'+location1.substring(location1.lastIndexOf("/"),location1.length),
					'onClosed':function () {
						window.parent.location.reload();
					}
				});
			}); */
			$("#howToAccessVideos").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : '${applicationScope.resourcePath}/../howToAccessVideos.htm?courseId='+this.title,
				});
			});
			$("#cantSeeCourses").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : 'cantSeeCourses.htm',
				});
			});
			$("#trainingCalendar").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : '${applicationScope.resourcePath}/../trainingCalendar.htm',
				});
			});
			$("#coursePending").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : '${applicationScope.resourcePath}/../s/coursePending.htm',
				});
			});
			$("#signUpLink").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 420,
					'height' : 300,
					'type' : 'iframe',
					'href' : '${applicationScope.resourcePath}/../register.htm'
				});
			});
			$("#howItWorks").live("click", function(){
				$.fancybox({
					'centerOnScroll':true,
					'width':680,
					'height':325,
					'type':'iframe',
					'href':'${applicationScope.resourcePath}/../howItWorks.htm'
				});
			});
			$("#courseExpired").live("click", function(){
				$.fancybox({
					'centerOnScroll':true,
					'width':680,
					'height':325,
					'type':'iframe',
					'href':'${applicationScope.resourcePath}/../courseExpired.htm'
				});
			});
			$("#cartList").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 960,
					'height' : 545,
					'type' : 'iframe',
					'href' : '${applicationScope.resourcePath}/../viewCart.htm',
					'onClosed':function () {
						window.parent.location.reload();
					}
				});
			});
			$("#noMachineSecretReceived").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : '${applicationScope.resourcePath}/../noMachineSecretReceived.htm',
				});
			});
			$("#viewMachineSecrete").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : 's/viewMachineSecrete.htm',
				});
			});
			$("#viewAllMachineSecretes").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : 's/viewAllMachineSecretes.htm',
				});
			});
			$("#gallery").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : 'gallery.htm',
				});
			});
			/* $("#purchaseCourse").live("click", function() {
				$.fancybox({
					'centerOnScroll' : false,
					'width' : 680,
					'height' : 325,
					'type' : 'iframe',
					'href' : this.title,
					'onClosed':function () {
						window.parent.location.reload();
					}
				});
			}); */
			var GPTab = "clientTab1";
			var GCTab = "clientDiv1";
			$("#clientList a")
				.live("click",function() {
						var s = $(this).attr('id'), res = s.split("Tab"), parent = "clientTab"
								+ res[1], content = "clientDiv" + res[1];
						if (GPTab != parent) {
							if (GCTab != "") {
								$('#' + GCTab).hide();
								$('#' + parent).removeClass('active');
								$('#' + GPTab).removeClass('active');
							}
							$('#' + content).show();
							$('#' + parent).addClass('active');
							GCTab = content;
							GPTab = parent;
						}
			});
			function navigateInPage(x){
				window.location.hash="";
				window.location.hash="#"+x;
				window.scrollTo(window.scrollX, window.scrollY - 120);
			}
			function getCouponInput(){
	    		document.getElementById("haveCoupon").innerHTML="<input type='text' name='couponCode' id='couponCode' placeholder='Coupon Code'/>&nbsp;&nbsp;<a class='btn btn-green btn-login' onclick='applyCoupon()'>Apply</a>";
	    	}
	    	function applyCoupon(){
	    		var couponCode=document.getElementById("couponCode").value;
	    		xmlhttp.open("GET","applyCouponCode.htm?couponCode="+couponCode,true);
				xmlhttp.onreadystatechange=updateCouponCodeStatus;
				xmlhttp.send(null);
	    	}
	    	function updateCouponCodeStatus() {
				if(xmlhttp.readyState==4){
					document.getElementById("haveCoupon").innerHTML="";
					var result=xmlhttp.responseText;
					document.getElementById("haveCoupon").innerHTML=result;
					if(result=="<b style='color:green;'>Coupon applied successfully</b>"){
						window.location.reload();
					}
				}
			}
		</script>
	</body>
</html>
