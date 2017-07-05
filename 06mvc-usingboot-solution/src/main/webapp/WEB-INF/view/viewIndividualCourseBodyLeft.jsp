<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="app-left">
	<div id="item-header">
		<div id="item-header-avatar">
			<a href="#" title="${course.name}">
				<img width="378" height="226" 
					src="${initParam.resourcePath}/images/courses/${course.imageName}.jpg" 
					class="attachment-full wp-post-image" alt="${course.name}"/>
			</a>
		</div>
		<div id="item-header-content" class="review-rating">
			<div class="star-rating">
				<a rel="tab" href="${initParam.resourcePath}/../viewReviews.htm?courseId=${course.courseId}">REVIEWS</a>
				<c:set value="${course.rating}" var="rating" scope="request"/>
				<c:import url="displayRating.jsp"/>
			</div>
			<div class="students">
				<i class="icon-user"></i>${course.numberOfLearners} &nbsp;Learners
			</div>
		</div>
	</div>
	<div class="fixedmenu-vertical">
		<div id="navSticky">
			<div class="item-list-tabs" role="navigation">
				<ul class="navigationmenu">
					<li id="about" class="current">
						<a href="#">About the Course</a>
					</li>
					<c:if test="${sessionScope.userDetails!=null and requestScope.machineId!=null}">
						<li id="curriculum">
							<a id="viewMachineSecrete">Machine Secret</a>
						</li>
					</c:if>
					<li id="faq">
						<a href="${initParam.resourcePath}/../allFaqs.htm">Faq's</a>
					</li>
					<li id="certification">
						<a href="#">Certification</a>
					</li>
					<li id="class-recording">
						<a href="#">Sample Class Recording</a>
					</li>
					<li id="upcoming-batch">
						<a href="#">Upcoming BAtches</a>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
</div>