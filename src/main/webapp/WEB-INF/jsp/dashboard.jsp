<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<body>
	<div>
		<div>
			<ul>
				<li><a
					href="<spring:url value="/developer/add" htmlEscape="true" />">Add
						New Developer</a></li>
				<li><a
					href="<spring:url value="/developer/list" htmlEscape="true" />">List Developers</a></li>
			</ul>
			<ul>
				<li><a
					href="<spring:url value="/story/add" htmlEscape="true" />">Add New Story</a></li>
				<li><a
					href="<spring:url value="/story/list" htmlEscape="true" />">List
						Stories</a></li>
			</ul>
			<ul>
				<li><a href="<spring:url value="/issue/add" htmlEscape="true" />">Add
						New Bug</a></li>
				<li><a
					href="<spring:url value="/issue/list" htmlEscape="true" />">List
						Bugs</a></li>
				<li><a
					href="<spring:url value="/issue/listopen" htmlEscape="true" />">List
						Open Bugs</a></li>
			</ul>
			<ul>
				<li><a href="<spring:url value="/team" htmlEscape="true" />">
						Create team</a></li>
				<li><a
					href="<spring:url value="/team/list" htmlEscape="true" />">List
						Teams</a></li>
				<li><a
					href="<spring:url value="/team/member" htmlEscape="true" />">Add member to Team
						</a></li>
			</ul>
			<ul>
				<li><a href="<spring:url value="/project" htmlEscape="true" />">
						Create team</a></li>
				<li><a
					href="<spring:url value="/project/list" htmlEscape="true" />">List
						Teams</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
