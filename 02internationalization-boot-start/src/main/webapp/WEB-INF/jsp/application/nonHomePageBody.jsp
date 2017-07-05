<%@page import="java.util.Enumeration"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="app-center">
	<tiles:insertAttribute name="leftSideBody"/>
	<tiles:insertAttribute name="rightSideBody"/>
	<div class="clear"></div>
</div>