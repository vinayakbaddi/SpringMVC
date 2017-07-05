function callMe() {
	var name=document.getElementById("name").value;
	var email=document.getElementById("email").value;
	var mobile=document.getElementById("mobile").value;
	var result=true;
	
	var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	if(!filter.test(email)){
		alert("Please enter valid email address");
		result=false;
		return;
	}
	if(mobile.length<10){
		alert("Phone number can not be less than 10 digit");
		result=false;
		return;
	}
	if(result){
		xmlhttp.open("GET","callMe.htm?name="+name+"&mobile="+mobile+"&email="+email,true);
		xmlhttp.onreadystatechange=updateCallMe;
		xmlhttp.send(null);
	}else{
		alert("Request not sent because of improper information entered");
	}
}
function updateCallMe() {
	if(xmlhttp.readyState==4){
		var result=xmlhttp.responseText;
		alert(result);
		document.getElementById("name").value="";
		document.getElementById("email").value="";
		document.getElementById("mobile").value="";
	}
}