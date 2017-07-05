<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div id="main-content">
	<!-- #featured -->
	<article>
		<tiles:insertAttribute name="bannerBox" />
		<div class="app-center">
			<tiles:insertAttribute name="homePageMainBody" />
			<div class="clearfix"></div>
			<%-- <tiles:insertAttribute name="clients" /> --%>
			<tiles:insertAttribute name="aboveFooter" />
		</div>
	</article>
	<!-- #mid-content -->
</div>