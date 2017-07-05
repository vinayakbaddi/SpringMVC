<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="course-divbg">
	<div class="title">All Courses</div> 
	<div class="course dir-list">
		<ul id="course-list" class="item-list">
			<c:if test="${courses.size()!=0}">
				<c:forEach items="${courses}" var="course">
					<li>
						<div class="item-avatar">
							<a href="viewIndividualCourse.htm?courseId=${course.courseId}" title="${course.name} View Details"><img
								width="378" height="226"
								src="resources/images/courses/${course.imageName}.jpg"
								alt="${course.name}"> </a>
						</div>
						<div class="item">
							<div class="item-title">
								<a href="viewIndividualCourse.htm?courseId=${course.courseId}">${course.name}</a>
							</div>
							<div class="item-meta">
								<div class="star-rating">
									<c:set value="${course.rating}" var="rating" scope="request"/>
									<c:import  url="displayRating.jsp"/>
									( <a href="viewReviews.htm?courseId=${course.courseId}"><strong itemprop="count">
										${course.numberOfReviews}
									</strong>
									REVIEW<c:if test="${course.numberOfReviews!=1}">S</c:if></a> )
								</div>
								<div class="students">
									<i class="icon-user"></i> ${course.numberOfLearners} Learners
								</div>
							</div>
							<div class="item-desc">
								<p>${course.description}</p>
							</div>
							<div class="item-credits">
								<span class="amount">${course.price} INR / ${course.priceUSD} USD</span>
								<div class="right">
									<a href="viewIndividualCourse.htm?courseId=${course.courseId}"
									 class="lnk-button lnk-blue purchase-course">View Details</a>
									<a href="#" class="lnk-button lnk-blue purchase-course" id="trainingCalendar">Attend Training</a>
									<a class="lnk-button lnk-blue add-to-cart" id="purchaseCourse"  href="/s/purchaseCourse.htm?courseId=${course.courseId}"
									title="s/purchaseCourse.htm?courseId=${course.courseId}">Purchase For Free</a>
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</li>
				</c:forEach>
			</c:if>
		</ul>
	</div>
	<c:if test="${courses.size()==0}">
		<div class="alert-box error"><span>ERROR:</span> There are no courses to display</div>
	</c:if>
	<input type="hidden" id="_wpnonce-course-filter"
		name="_wpnonce-course-filter" value="3d2fcdf87d"> <input
		type="hidden" name="_wp_http_referer" value="all-courses/">
</div>