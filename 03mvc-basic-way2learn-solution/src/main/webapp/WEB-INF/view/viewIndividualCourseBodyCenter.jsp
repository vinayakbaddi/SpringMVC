<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="app-cmain">
	<div id="writeReview"></div>
    <div id="item-body" class="course-contents">
		<div class="course-title">
			<h1>${course.name}</h1>
		</div>
        <h6>
        	<p>${course.description}</p>
        	<br/>
        </h6>
        
        <div class="course-description" id="startLearning">
					<h3 class="coursetab-title">Course Topics (Start Learning)</h3>
				</div>
				<c:import url="/WEB-INF/view/courseTopics/${course.imageName}.jsp"/>
       
		<c:import url="/WEB-INF/view/courseDescription/${course.imageName}.jsp"/>
	</div>
</div>            