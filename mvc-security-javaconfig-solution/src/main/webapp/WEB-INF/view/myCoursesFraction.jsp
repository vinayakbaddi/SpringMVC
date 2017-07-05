<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${SPRING_SECURITY_CONTEXT!=null}">
	<div class="course-divbg">
		<div class="title">My Courses</div> 
		<c:if test="${myPurchases!=null}">
			<c:if test="${myPurchases.size()!=0}">
					<div class="course dir-list">
						<ul id="course-list" class="item-list">
							<c:set var="c" value="1"/>
							<c:forEach items="${myPurchases}" var="myPurchase">
								<c:set var="course" value="${myPurchase.course}" scope="request"/>
								<li>
									<div class="item-avatar">
										<a href="viewIndividualCourse.htm?courseId=${course.courseId}" title="${course.name} View Details"><img
											width="378" height="226"
											src="${initParam.resourcePath}/images/courses/${course.imageName}.jpg"
											alt="${course.name}"> </a>
									</div>
									<div class="item">
										<div class="item-title">
											<a href="viewIndividualCourse.htm?courseId=${course.courseId}">${course.name}</a>
										</div>
										<div class="item-meta">
											<div class="star-rating">
												<c:set value="${course.rating}" var="rating" scope="request"/>
												<c:import url="displayRating.jsp"/>
												( <a href="viewReviews.htm?courseId=${course.courseId}"><strong itemprop="count">${course.numberOfReviews}</strong>
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
											<span class="amount">
												<c:if test='${myPurchase.status=="pending"}'>
													<b style="color: red;">
														This course is still pending for you.<a href="#" id="coursePending">Learn More</a><br/>
														<a style="color: blue; text-decoration: underline;" id="seeOurAccountDetails" href="#">See our account details</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<a style="color: blue; text-decoration: underline;" href="http://www.samplecoursevideos.way2learn.co.in/Way2Learn_Account_Details.pdf" target="_blank">Download our account details</a>
													</b>
												</c:if>
												<c:if test='${myPurchase.status=="active"}'>
													<b style="color: green;">This course is active.</b>
												</c:if>
												<c:if test='${myPurchase.status=="expired"}'>
													<b style="color: red;">This course is expired for you.<a href="#" id="courseExpired">Learn More</a></b>
												</c:if>
												<c:if test='${myPurchase.machineId==null and myPurchase.status=="active"}'>
													<div id="machineIdFirst${c}" class="showE">
														Please enter <b style="color: red;">machine id</b> <a href="#" onclick="getMachineIdInput(this,'${c}')" title="${course.courseId}">here</a> for getting password.
													</div>
													<c:set var="c" value="${c+1}"/>
												</c:if>
												<c:if test="${myPurchase.machineId!=null and myPurchase.machineSecret==null}">
													<b style="color: green;">You will get machine secret in 24 hours.
														<a id="noMachineSecretReceived" href="#" style="color: red;">
															Didn't get?
														</a>
													</b>
												</c:if>
												<c:if test="${myPurchase.machineId!=null and myPurchase.machineSecret!=null}">
													<b style="color: green;">Machine secret is : ${myPurchase.machineSecret}</b>
												</c:if><br/>
												<c:if test='${myPurchase.purchaseType=="oneDay"}'>
													<b style="color: red;">You have got one day licence, you can purchase life time licence below.</b>
												</c:if>
											</span>
											<div class="right">
												<a href="viewIndividualCourse.htm?courseId=${course.courseId}" class="lnk-button lnk-blue purchase-course">View Details</a>
												<c:if test='${myPurchase.purchaseType=="oneDay"}'>
													<a href="${initParam.resourcePath}/../s/purchaseCourse.htm?courseId=${course.courseId}" class="lnk-button lnk-blue purchase-course">Purchase Videos</a>
												</c:if>
												<c:if test='${myPurchase.purchaseType=="lifeTime"}'>
													<a href="#" class="lnk-button lnk-blue purchase-course" id="trainingCalendar">Attend Training</a>
												</c:if>
												<c:if test='${myPurchase.status=="active"}'>
													<a href="viewIndividualCourse.htm?courseId=${course.courseId}" class="lnk-button lnk-blue add-to-cart">Start Learning</a>
												</c:if>
												<c:if test='${myPurchase.status=="pending" and myPurchase.onlinePayment}'>
													<a href="${initParam.resourcePath}/../s/purchaseCourse.htm?courseId=${course.courseId}" class="lnk-button lnk-blue add-to-cart">Purchase Videos</a>
												</c:if>
												<c:if test='${myPurchase.status=="pending" and !myPurchase.onlinePayment}'>
													<a href="viewIndividualCourse.htm?courseId=${course.courseId}" class="lnk-button lnk-blue add-to-cart">Start Learning</a>
												</c:if>
												<c:if test='${myPurchase.status=="expired"}'>
													<a onclick='addToCart(${course.courseId})' class="lnk-button lnk-blue add-to-cart">Purchase Videos</a>
												</c:if>
											</div>
										</div>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<input type="hidden" id="_wpnonce-course-filter"
						name="_wpnonce-course-filter" value="3d2fcdf87d"> <input
						type="hidden" name="_wp_http_referer" value="/all-courses/">
			</c:if>
			<c:if test="${myPurchases.size()==0 or myPurchases==null}">
				<div class="alert-box error">
					<span>Sorry:</span>
					There are no courses that you have purchased
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;
					<a href="#" id="cantSeeCourses">Can't see your courses?</a>
					</div>
			</c:if>
		</c:if>
	</div>
</c:if>