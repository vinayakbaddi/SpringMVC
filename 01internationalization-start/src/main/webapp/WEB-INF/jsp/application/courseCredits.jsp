<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="course-credits">
	<c:if test="${courseStatusForThisUser==null}">
		<h3>Price <span class="amount">${course.price} INR / ${course.priceUSD} USD</span></h3>
	</c:if>
	<c:if test='${courseStatusForThisUser!=null}'>
		<%-- <c:if test="${transactionStartingDate!=null}">
			<c:set value="<%=Calendar.getInstance() %>" var="calendar" scope="page"/>
			<c:set value="<%=new Date() %>" var="now" scope="page"/>
			${calendar.setTime(transactionStartingDate)}
			${calendar.add(2, 6)}
			<fmt:formatDate value="${calendar.getTime()}" pattern="dd MMM yyyy" var="expiryDate"/>
		</c:if> --%>
		<fmt:formatDate value="${expiryDate}" pattern="dd MMM yyyy" var="expiryDate"/>
		<c:if test='${courseStatusForThisUser=="pending"}'>
			<span class="amount" style="color: red;">Status : Pending <a href="#" id="coursePending">learn more</a></span>
		</c:if>
		<c:if test='${courseStatusForThisUser=="active"}'>
			<span class="amount">Expires on : ${expiryDate}</span>
		</c:if>
		<c:if test='${courseStatusForThisUser=="expired"}'>
			<span class="amount" style="color: red;">
				Expired on : ${expiryDate}
				<a href="#" id="courseExpired">learn more</a>
				<b style="color: green;">${course.price} INR / ${course.priceUSD} USD</b>
			</span>
		</c:if>
	</c:if>
	<div class="course-link">
		<c:if test="${courseStatusForThisUser==null}">
			<a class="lnk-button lnk-blue" id="purchaseCourse"  href="${applicationScope.resourcePath}/../s/purchaseCourse.htm?courseId=${course.courseId}">
				Purchase For Free
			</a>
		</c:if>
		<c:if test='${courseStatusForThisUser!=null}'>										
			<c:if test='${courseStatusForThisUser=="active" and requestScope.machineId!=null}'>
				<a class="lnk-button lnk-blue" href="${applicationScope.resourcePath}/../s/writeReview.htm?courseId=${course.courseId}">Write Review</a>
			</c:if>
			<c:if test='${courseStatusForThisUser=="active" and requestScope.machineId==null}'>
				<div id="machineIdFirst">
					<a class="lnk-button lnk-blue" onclick="getMachineIdInput(this)" title="${course.courseId}">Enter Machine Id</a>
				</div>
			</c:if>
			<c:if test='${courseStatusForThisUser=="expired"}'>
				<a class="lnk-button lnk-blue" href="${applicationScope.resourcePath}/../s/purchaseCourse.htm?courseId=${course.courseId}">Purchase <c:if test="${course.mainCourse==null and fn:length(subCoursesOfCurrentCourse)!=0}">Full </c:if>Course</a>
			</c:if>
		</c:if>
	
			<a class="lnk-button lnk-blue" onclick="navigateInPage('startLearning')">Start Learning&nbsp;&nbsp;
				<img src="${applicationScope.resourcePath}/images/arrow-icon-wscr.png" alt="Watch Sample Class Recording" width="18px" height="18px"/>
			</a>
	
		
	</div>
</div>