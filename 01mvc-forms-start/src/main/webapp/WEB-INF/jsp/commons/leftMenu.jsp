<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-left b-shadow">
	<h3>Discover Courses</h3>
	<div class="item-list-tabs" role="navigation">
		<ul class="menu-list">
			<c:if test="${courses.size()!=0}">
				<c:forEach items="${courses}" var="course" begin="0" end="9">
					<li><a href="viewIndividualCourse.htm?courseId=${course.courseId}">${course.name}</a></li>
				</c:forEach>
				<li><a href="browseCourses.htm">View more courses</a></li>
			</c:if>
			<c:if test="${courses.size()==0}">
				No Courses to display
			</c:if>
		</ul>
	</div>
</div>