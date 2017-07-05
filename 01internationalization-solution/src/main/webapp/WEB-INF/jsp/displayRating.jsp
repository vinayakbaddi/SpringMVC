<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${rating==5}">
	<c:forEach begin="1" end="5">
		<span class="fill"></span>
	</c:forEach>
</c:if>
<c:if test="${rating==4}">
	<c:forEach begin="1" end="4">
		<span class="fill"></span>
	</c:forEach>
	<span class="half"></span>
</c:if>
<c:if test="${rating==3}">
	<c:forEach begin="1" end="3">
		<span class="fill"></span>
	</c:forEach>
	<span class="half"></span>
	<span class="none"></span>
</c:if>