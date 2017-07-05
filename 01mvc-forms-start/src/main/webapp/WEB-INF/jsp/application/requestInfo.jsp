<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<style>
.errors{
	color: red;
	font-weight: bold;
	
}
</style>

<div class="action-container">
	<div class="page-title">Request Info</div>                     
</div>
<div class="app-content app-main">     
	<div class="form-page-content">
		
		
		<form method="post" class="form-horizontal">
		
		
	
		
			Please update your personal details by filling up the following form.
			<p>
				This information will help us to communicate better for
				Feedbacks, personalized support queries and class schedules.
			</p><br/><br/>
			
			<h3 class="headingprofile">
				Fill in the form below
			</h3>
			
			
			<div class="form-group">
				<label class="control-label">Name: </label>
				<div class="form-feild">		
					<input type="text" name="name" class="form-control">
								
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">Email: </label>
				<div class="form-feild">
					<input type="email" name="email" class="form-control">	
							
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label">Age: </label>
				<div class="form-feild">
					<input type="text" name="age" class="form-control">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label">DOB: </label>
				<div class="form-feild">
					<input type="text" name="dob" class="form-control">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label">City: </label>
				<div class="form-feild">
					<input type="text" name="city" class="form-control">	
					
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">Mobile:
				</label>
				<div class="form-feild">
					<input type="text" name="mobile" class="form-control">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label">Query:
				</label>
				<div class="form-feild">
				
			
					<textarea rows="3" name="query" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">&nbsp;</label>
				<div class="form-feild">
					
				<button class="btn btn-blue" type="submit" id="update_user_profile_btn">Send Request</button></div>
			</div>
		
		</form>          
	</div>
</div>