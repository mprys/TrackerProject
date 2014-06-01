<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css">

		<script type="text/javascript"  src="//code.jquery.com/jquery-1.10.2.min.js"></script>
		<script type="text/javascript"  src="//cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"  src="//cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>

		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').dataTable();
			} );
		</script>
	</head>
<body>
<a href="<spring:url value="/" htmlEscape="true" />">Dashboard</a>
	<div  class="container">
<c:choose>
	<c:when test="${user.id == null}">
		<c:set var="method" value="post"/>
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put"/>
	</c:otherwise>
</c:choose>
	<div>
		<form:form method="${method}" modelAttribute="user">
			<label>User Name : </label><form:input path="userName" />
			<br>
			<label>First Name : </label><form:input path="firstName" />
			<br>
			<label>Last Name : </label><form:input path="lastName" />
			<br>
			<c:choose>
                <c:when test="${user.id == null}">
                    <button type="submit">Create User</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update User</button>
                </c:otherwise>
            </c:choose>
		</form:form>
	</div>
	
<table class="table table-striped table-bordered" id="example">
	<thead>
		<tr>
			<th>ID</th>
				<th>UserName</th>
				<th>Name Surname</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user" varStatus="counter" >
				<tr class="selected" >
					<td>${counter.index + 1}</td>
					<td>${user.userName}</td>
					<td>${user.firstName} ${user.lastName}</td>
<%-- 					<td><a href="<spring:url value="/team/members/${team.id}" htmlEscape="true" />">Add New Members</a> / --%>
<%-- 					    <a href="<spring:url value="/team/edit/${team.id}" htmlEscape="true" />">Edit</a> /  --%>
<%-- 						<a href="<spring:url value="/team/remove/${team.id}" htmlEscape="true" />">Remove</a> --%>
<!-- 					</td> -->
				</tr>
			</c:forEach>
	</tbody>
</table>

</div>
</body>
</html>
