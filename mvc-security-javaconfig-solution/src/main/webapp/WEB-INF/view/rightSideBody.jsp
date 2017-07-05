<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="app-right t20-m">
	<div class="sub-head">
		<a href="#" title="View More Testmonials" class="link" >Best Testimonials</a>
	</div>
	<c:if test="${goodTestimonials.size()!=0}">
		<c:set var="userDetails" value="${goodTestimonials.get(0).purchase.userDetails}"/>
		<div class="tab-content each-reviews">
	         <div class="tab-pane active">
	           	<ul class="more-posts">
	                <li>
	                	<span>
	                		<a href="#" title="Read all Testimonials By This User">
	                			<img src="${userDetails.imageLocation}" alt="image"/>
	                		</a>
	                 		<span>
	                 			<a href="#" target="_blank" title="Read all Testimonials By This User">${userDetails.fullName}</a>
	                 		</span>
	                 	</span>
	                   <br/>
	                    <div class="review-page-content">${userDetails.occupation}</div>
	                </li>
	                <li class="star-rating">
	                	<a href="#" title="View Same Rated Testimonials">
	                		<c:if test="${goodTestimonials.get(0).rating==5}">
								<c:forEach begin="1" end="${goodTestimonials.get(0).rating}">
									<span class="fill"></span>
								</c:forEach>
							</c:if>
							<c:if test="${goodTestimonials.get(0).rating==4}">
								<c:forEach begin="1" end="${goodTestimonials.get(0).rating}">
									<span class="fill"></span>
								</c:forEach>
								<c:forEach begin="${goodTestimonials.get(0).rating+1}" end="5">
									<span class="half"></span>
								</c:forEach>
							</c:if>
							<c:if test="${goodTestimonials.get(0).rating==3}">
								<c:forEach begin="1" end="${goodTestimonials.get(0).rating}">
									<span class="fill"></span>
								</c:forEach>
								<c:forEach begin="${goodTestimonials.get(0).rating+1}" end="4">
									<span class="half"></span>
								</c:forEach>
								<span class="none"></span>
							</c:if>
						</a>
	                </li>
	            </ul>
	         </div>
	         <div class="cats">
	             <ul class="linked-link">
	                 <li>Follow me on</li>
	                 <li>|<a href="${userDetails.profileLink}" target="_blank">Facebook</a></li>
	             </ul>
	         </div>
	         <p class="reviewsquots">${goodTestimonials.get(0).description}</p>
	         <a href="${applicationScope.resourcePath}/../viewReviews.htm?courseId=0" id="readmore2" class="link" title="View More Testmonials">View More</a>
	     </div>
	</c:if>
     <c:if test="${goodTestimonials.size()==0}">
         	<ul class="more-posts">
              <li>
              	<h3>No Testimonials to display</h3>
              </li>
         </ul>
      </c:if>
</div>
<jsp:include page="rightSideBody3.jsp"/>