<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="action-container">
    <div class="page-title">Contact Us</div>                     
</div>
<style>
  #map-canvas {
    width: 500px;
    height: 250px;
  }
</style>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<!-- <script>
  function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var mapOptions = {
      center: new google.maps.LatLng(13.018970, 77.682808),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(mapCanvas, mapOptions)
    
  }
  google.maps.event.addDomListener(window, 'load', initialize);
</script> -->
<script>
  function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var latlng=new google.maps.LatLng(13.018970, 77.682808);
    var mapOptions = {
      center: latlng,
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP/* SATELLITE */
    }
    var map = new google.maps.Map(mapCanvas, mapOptions)
    var marker = new google.maps.Marker( {map: map,position: latlng,title: "Wa2Learn Software Pvt. Ltd.,Bangalore-16"});
  }
  google.maps.event.addDomListener(window, 'load', initialize);
</script>
<div class="app-content app-main">
        	<div class="form-page-content">
				<div class="inner-content">
                    <h2 class="sub-head">${aboutUs.companyName}</h2>
                    <div class="office-details">
                         <div class="office">
                            <h2 class="office-place">${aboutUs.address.city} (Head) Office</h2>
                            ${aboutUs.address.streetLine1}<br/>
                            ${aboutUs.address.streetLine2}<br/>
                            ${aboutUs.address.city} - ${aboutUs.address.pinCode}<br/>
                            ${aboutUs.address.state}, ${aboutUs.address.country}<br/>
                            <a href="https://www.google.co.in/maps/place/13%C2%B001'08.3%22N+77%C2%B040'58.1%22E/@13.01897,77.682808,18z/data=!3m1!4b1!4m2!3m1!1s0x0:0x0" target="_blank">Google Map</a>&nbsp;
                            <br/>
                            Ph.  ${aboutUs.contactSupport}<br/>
                            Email : ${aboutUs.email}<br/>
                        </div>	
                        <div id="map-canvas"></div>
                     </div> 
                     <div class="clear"></div>
                     <br> 
                     <div class="divider-line"></div>  
                    <form class="form-horizontal" role="form" method="post" action="requestInfo.htm">
						Fill up the following form below to get support on your query.
						<p>
							This information will help us to communicate better for
							Feedbacks, personalized support queries and class schedules.
						</p>
						<c:if test='${statusRI=="success"}'>
							<p style="color: green;">
								Your request for info is received by us successfully.
							</p>
						</c:if>
						<c:if test='${statusRI=="failure"}'>
							<p style="color: red;">
								We failed to receive Your request for info, kindly try again after sometime.
							</p>
						</c:if>
						<h3 class="headingprofile">
							Fill in the form below
						</h3>
						<div class="form-group">
							<label class="control-label">Name: </label>
							<div class="form-feild">
								<input type="text" class="form-control" id="name" name="name" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Email: </label>
							<div class="form-feild">
								<input type="text" class="form-control" id="email" name="email" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Mobile:
							</label>
							<div class="form-feild">
								<input class="form-control" id="mobile" name="mobile" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Company:
							</label>
							<div class="form-feild">
								<input class="form-control" id="company" name="company" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Query:
							</label>
							<div class="form-feild">
								<textarea class="form-control" rows="3" id="description" required="required" name="query"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">&nbsp;</label>
							<div class="form-feild"><button class="btn btn-blue" type="submit" id="update_user_profile_btn">Send Request</button></div>
						</div>
					</form>
				</div>
            </div>       	
            			
        </div>