<script type="text/javascript">
	function submitQuery() {
		var result=true;
		var firstName=document.getElementById("firstName").value;
		if(firstName.length<4||firstName==""){
			alert("Please enter first name at least with 4 characters");
			result=false;
			return;
		}
		var lastName=document.getElementById("lastName").value;
		if(lastName.length<4||lastName==""){
			alert("Please enter last name at least with 4 characters");
			result=false;
			return;
		}
		var mobile=document.getElementById("mobile1").value;
		if(mobile.length<10||mobile==""){
			alert("Please enter mobile number at least with 10 characters");
			result=false;
			return;
		}
		var email=document.getElementById("email123").value;
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
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
		xmlhttp.open("GET","submitQuery.htm?firstName="+firstName+"&lastName="+lastName+"&mobile="+mobile+"&email="+email+"&query="+query,true);
		xmlhttp.onreadystatechange=updateSendQuery;
		xmlhttp.send(null);
	}
	function updateSendQuery() {
		if(xmlhttp.readyState==4){
			var result=xmlhttp.responseText;
			alert(result);
		}
	}
</script>
<div class="sub-head">Drop us a Query</div>
<div class="query-details">
    <form action="#">
      <div class="form-group">
      	<input type="text" id="firstName" class="control firstname" required placeholder="First Name">
        <input type="text" id="lastName" class="control lastname" required placeholder="Last Name">
        <input type="text" id="mobile1" class="control" required placeholder="Mobile Number">
        <input type="text" id="email123" class="control" required placeholder="Email">
        <textarea id="query" class="control txtareavalue" rows="2" placeholder="Your Query?" required="required"></textarea>
      </div>
      <input class="btn btn-green submit-query" type="button" onclick="submitQuery()" id="sq" value="SUBMIT QUERY"/>
    </form>
</div>