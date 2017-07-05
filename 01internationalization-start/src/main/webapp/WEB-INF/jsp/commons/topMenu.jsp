<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="header-container">
	<div id="headerSticky">
		<div class="stickyCenter">
			<div class="app-center">
				<h1>
					<a href="home.htm">Way2Learn</a>
				</h1>
				<div class="top-right">
					<div class="support">
					<a href="home.htm?locale=en">English</a> | <a href="home.htm?locale=es">Spanish</a>
						<a class="btn btn-green btn-login" href="browseCourses.htm">Browse Courses</a>
						<c:if test="${sessionScope.userDetails!=null}">
							<c:if test='${userDetails.role.contains("ROLE_ADMIN")}'>
								<a class="btn btn-green btn-login" href="adm/allFunctionalities.htm">Admin Funcs</a>
							</c:if>
							<c:if test='${userDetails.role.contains("ROLE_MYUSER")}'>
								<a class="btn btn-green btn-login" href="s/referFriends.htm">Refer Friends</a>
							</c:if>
						</c:if>
					</div>
					<div class="support"></div>
					<div class="support"></div>
					<c:if test="${sessionScope.userDetails==null}">
						<div class="support"></div>
					<div class="support"></div>
					</c:if>
					<div class="support">
						<a href="contactSupport.htm" style="color: black;">
							<i></i>
							<span class="small"><spring:message code="contactsupport"/></span> 
							<span>${aboutUs.contactSupport}</span>
						</a>
					</div>
					<c:if test="${sessionScope.SPRING_SECURITY_CONTEXT==null}">
						<a id="signInLink" class="btn btn-green btn-login" href="javascript:signIn()">Sign In</a>
					</c:if>
					<c:if test="${sessionScope.SPRING_SECURITY_CONTEXT!=null}">
						<a  href="logout.htm" class="btn btn-green btn-login">Sign Out</a>
					</c:if>
				</div>
			</div>
			<div id="main-nav" role="navigation">
				<div class="app-center">
					<ul id="menu-main" class="menu">
						<li class="menu-item">
							<a href="home.htm" <c:if test='${activeLink=="home.htm"}'>class="active"</c:if>>
								<i class="home"></i>
								<spring:message code="home"/>
							</a>
						</li>
						<li class="menu-item">
							<a href="browseCourses.htm" <c:if test='${activeLink=="browseCourses.htm"}'>class="active"</c:if>>
								<i class="courses"></i>
								<spring:message code="courses"/>
							</a>
							<div class="dropdown">
								<ol>
									<c:if test="${courses.size()!=0}">
										<c:forEach items="${courses}" var="course">
											<li><a href="viewIndividualCourse.htm?courseId=${course.courseId}">${course.name}</a></li>
										</c:forEach>
									</c:if>
									<c:if test="${courses.size()==0}">
										Sorry No Courses to display
									</c:if>
								</ol>
							</div>
						</li>
						<li class="menu-item">
							<a href="viewAllTrainings.htm">
								<i class="calendar"></i>
								<spring:message code="trainingcalendar"/>
							</a>
						</li>
						<li class="menu-item">
							<a href="#" id="gallery">
								<i class="gallery"></i>
								<spring:message code="gallery"/>
							</a>
						</li>
						<li class="menu-item">
							<a href="contactSupport.htm" <c:if test='${activeLink=="contactSupport.htm" or activeLink=="aboutUs1.htm"}'>class="active"</c:if>>
								<i class="about"></i>
								<spring:message code="contactus"/>
							</a>
							<div class="dropdown">
								<ol>
									<li><a href="contactSupport.htm">Contact Us</a></li>
									<li><a href="aboutUs1.htm">About Us</a></li>
								</ol>
							</div>
						</li>
						<li class="menu-item">
							<a href="allFaqs.htm" <c:if test='${activeLink=="allFaqs.htm"}'>class="active"</c:if>>
								<i class="faq"></i>
								<spring:message code="faqs"/>
							</a>
							<div class="dropdown">
								<ol>
									<li><a href="allFaqs.htm">FAQs</a></li>
									<li><a href="privacyPolicy.htm">Privacy Policy</a></li>
									<li><a href="cancellationPolicy.htm">Cancellation Policy</a></li>
									<li><a href="termsOfUse.htm">Terms Of Use</a></li>
									<li><a href="knowHowToGetCourseForFree.htm">Courses For Free</a></li>
									<li><a href="productsAndServices.htm">Products and Services</a></li>
									<li><a href="flowOfPurchase.htm">Flow Of Purchase</a></li>
								</ol>
							</div>
						</li>
						<li class="menu-item">
							<a href="requestInfo.htm" <c:if test='${activeLink=="requestInfo.htm"}'>class="active"</c:if>>
								<i class="request"></i>
								Request Info
							</a>
						</li>
						<c:if test="${sessionScope.SPRING_SECURITY_CONTEXT!=null}">
							<li class="menu-item">
								<a href="#">
									<i class="profile"><img alt="Img" src="${userDetails.imageLocation}" height="28" width="25"/></i>
									My Profile
								</a>
								<div class="dropdown">
									<ol>
										<li>
											<a href="#">Welcome ${userDetails.fullName}</a>
										</li>
										<li>
											<a id="viewAllMachineSecretes">Machine Secret</a>
										</li>
										<li>
											<a href="s/myProfile.htm">My Profile</a>
										</li>
										<c:if test='${userDetails.role.contains("ROLE_ADMIN")}'>
											<li><a href="adm/allFunctionalities.htm">Administrator</a></li>
										</c:if>
										<li>
											<a href="s/myCourses.htm">My Courses</a>
										</li>
										<li>
											<a href="s/referFriends.htm">Refer Friends</a>
										</li>
										<li>
											<a href="#">${userDetails.email}</a>
										</li>
										<li>
											<a href="logout.htm">Sing Out</a>
										</li>
									</ol>
								</div>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>