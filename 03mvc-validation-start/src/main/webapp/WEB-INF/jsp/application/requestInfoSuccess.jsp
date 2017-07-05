<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="action-container">
	<div class="page-title">Request Info Received</div>                     
</div>
<div class="app-content app-main">        
	<div class="form-page-content">
		Received your Details as Follows :<br/>
		
		Name :${param.name} <br/>
		E-Mail :${param.email}<br/>
		Age :${param.age}<br/>
			ssn:${requestInfo.ssn } <br/>
		Mobile:${requestInfo.mobile} <br/>
			City:   ${requestInfo.city} <br/>
		Company :${requestInfo.company}<br/>
		Query:${requestInfo.query} <br/>
		
		We will revert back to you ASAP.
	</div>
</div>