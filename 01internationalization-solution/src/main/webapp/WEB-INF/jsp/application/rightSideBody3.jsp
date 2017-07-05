<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="app-right t20-m" id="rightSideBody">
	<c:import url="/WEB-INF/jsp/application/requestACallBack.jsp"/>
	<div class="divider"></div>
	<c:import url="/WEB-INF/jsp/application/contactUs.jsp"/>
</div>
<script type="text/javascript" src="${applicationScope.resourcePath}/js/callMe.js">
</script>