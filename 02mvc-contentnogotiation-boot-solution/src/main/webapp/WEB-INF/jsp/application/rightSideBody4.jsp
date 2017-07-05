<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="app-right">
	<script type="text/javascript">
		function submitQuery() {
			var result=true;
			var firstName=document.getElementById("firstName").value;
			if(firstName.length<4||firstName==""){
				alert("Please enter name at least with 4 characters");
				result=false;
				return;
			}
			var lastName=document.getElementById("lastName").value;
			var mobile=document.getElementById("mobile").value;
			var email=document.getElementById("email").value;
			var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z]{5})+\.)+([a-zA-Z]{3})+$/;
			if(!filter.test(email)){
				alert("Please enter valid email id ex: test@gmail.com");
				result=false;
				return;
			}
			var query=document.getElementById("query").value;
			if(query.length<30||query==""){
				alert("Please enter your query with minimum 30 characters before submitting query");
				result=false;
				return;
			}
			if(result){
				sendQuery(firstName,lastName,mobile,email,query);
			}else{
				alert("Please enter proper data before submitting query");
			}
			
		}
		function sendQuery(firstName,lastName,mobile,email,query){
			xmlhttp.open("GET","${applicationScope.resourcePath}/../submitQuery.htm?firstName="+firstName+"&lastName="+lastName+"&mobile="+mobile+"&email="+email+"&query="+query,true);
			xmlhttp.onreadystatechange=updateSendQuery;
			xmlhttp.send(null);
		}
		function updateSendQuery() {
			if(xmlhttp.readyState==4){
				var result=xmlhttp.responseText;
				document.getElementById("sq").innerHTML=""+result;
				alert(result);
			}
		}
		function validateFirstName(firstName) {
			if(firstName.length<4){
				return false;
			}
			return true;
		}
		function validateEmail(email) {
			var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z]{5})+\.)+([a-zA-Z]{3})+$/;
			return filter.test(email);
		}
		function validateQuery(query) {
			if(firstName.length<30){
				return false;
			}
			return true;
		}
	</script>
	<c:if test="${courseStatusForThisUser!=null}">
		<c:import url="/WEB-INF/jsp/application/courseCredits.jsp"/>	
	</c:if>
    <div class="divider"></div>
	<div class="clear"></div>
    <div class="contact-mobile">
        <div class="phoneicon">
        	<ul>
                <li>INDIA : ${aboutUs.contactSupport}</li>
                <li class="email-resposive">Email Us :
                    <a title="Click to send us a mail" href="https://mail.google.com/mail/u/0/?view=cm&fs=1&to=${aboutUs.email}&tf=1" target="_blank">${aboutUs.email}</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="divider"></div>
	<c:import url="/WEB-INF/jsp/application/submitQuery.jsp"/>
   <div class="divider"></div>             
</div>