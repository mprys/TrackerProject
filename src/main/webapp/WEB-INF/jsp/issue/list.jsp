<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<body>
<a href="<spring:url value="/" htmlEscape="true" />">Dashboard</a>
	<div>
		<h1>Bug List</h1>
		<table>
			<thead>
				<th>Title</th>
				<th>Description</th>
				<th>Status</th>
				<th>Priority</th>
				<th>Create Date</th>
				<th>Operation</th>
			</thead>
		
			<c:forEach items="${bugs}" var="bug" >
				<tr>
					<td>${bug.title}</td>
					<td>${bug.description}</td>
					<td>${bug.status}</td>
					<td>${bug.priority}</td>
					<td>${bug.createDate}</td>
					<td><a href="<spring:url value="/issue/edit/bug/${bug.id}" htmlEscape="true" />">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
