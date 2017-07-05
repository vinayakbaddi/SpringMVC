<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="hcol-content b-shadow">
	<div class="mostLearned">
		<h2>Most Viewed Courses</h2>
		<div id="viewedCourses">
			<a href="browseCourses.htm" class="btn btn-white btn-more" title="View More">...</a>
			<ul class="bjqs">
				<li>
					<c:if test="${sortedCourses.size()>=1}">
						<c:set var="tempCourse" value="${sortedCourses.get(0)}" scope="request"/>
						<c:import url="/WEB-INF/jsp/commons/mostViewedCourses.jsp"/>
					</c:if>
					<c:if test="${sortedCourses.size()>=2}">
						<c:set var="tempCourse" value="${sortedCourses.get(1)}" scope="request"/>
						<c:import url="/WEB-INF/jsp/commons/mostViewedCourses.jsp"/>
					</c:if>
				</li>
				<li>
					<c:if test="${sortedCourses.size()>=3}">
						<c:set var="tempCourse" value="${sortedCourses.get(2)}" scope="request"/>
						<c:import url="/WEB-INF/jsp/commons/mostViewedCourses.jsp"/>
					</c:if>
					<c:if test="${sortedCourses.size()>=4}">
						<c:set var="tempCourse" value="${sortedCourses.get(3)}" scope="request"/>
						<c:import url="/WEB-INF/jsp/commons/mostViewedCourses.jsp"/>
					</c:if>
				</li>
				<li>
					<c:if test="${sortedCourses.size()>=5}">
						<c:set var="tempCourse" value="${sortedCourses.get(4)}" scope="request"/>
						<c:import url="/WEB-INF/jsp/commons/mostViewedCourses.jsp"/>
					</c:if>
					<c:if test="${sortedCourses.size()>=6}">
						<c:set var="tempCourse" value="${sortedCourses.get(5)}" scope="request"/>
						<c:import url="/WEB-INF/jsp/commons/mostViewedCourses.jsp"/>
					</c:if>
				</li>
			</ul>
		</div>
	</div>
	<div class="testimonials">
		<h2>Testimonials${goodTestimonials.size()}</h2>
		<div id="testimonials">
			<a href="testimonials.html" class="btn btn-white btn-more"
				title="View More">...</a>
			<ul class="bjqs">
				<c:forEach items="${goodTestimonials}" var="goodTestimonial">
					<li>
						<div class="tst-img">
							<a href="#" title="Read all Testimonials By This User">
								<img src="${goodTestimonial.purchase.userDetails.imageLocation}" />
							</a>
						</div>
						<div class="tst-right">
							<div class="name">
								<a href="#" title="Read all Testimonials By This User"><%-- ${goodTestimonial.subTransaction.transaction.userDetails.fullName} --%></a>
							</div>
							<div class="star-rating">
								<a href="#" title="View Same Rated Testimonials">
									<c:forEach begin="1" end="${goodTestimonial.rating}">
										<span class="fill"></span>
									</c:forEach>
									<c:forEach begin="${goodTestimonial.rating+1}" end="5">
										<span class="half"></span>
									</c:forEach>
								</a>
							</div>
							<div class="title">
								<a href="#" title="Read This Testimonial">${goodTestimonial.title}</a>
							</div>
							<div class="desc">
								<a href="#" title="Read It Completely">${goodTestimonial.description}</a>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
</div>