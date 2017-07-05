<div class="list-row">
	<div class="mlc-img">
		<img src="${initParam.resourcePath}/images/courses/${tempCourse.imageName}.jpg" alt="${tempCourse.name}"
		/>
	</div>
	<div class="mlc-right">
		<div class="title">
		<a href="${initParam.resourcePath}/../viewIndividualCourse.htm?courseId=${tempCourse.courseId}">${tempCourse.name}</a>
		</div>
		<div class="viewed">
			<i></i>${tempCourse.numberOfLearners} Learners
		</div>
		<div class="time">
			<i></i>${tempCourse.durationInHours} Hrs
		</div>
		<div class="viewed">
			<i></i>${tempCourse.numberOfViews} People Viewed
		</div>
	</div>
</div>