<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<!-- 		<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> -->
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css">

		<script type="text/javascript"  src="//code.jquery.com/jquery-1.10.2.min.js"></script>
		<script type="text/javascript"  src="//cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"  src="//cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
		
		<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>
<body>
<a href="<spring:url value="/" htmlEscape="true" />">Dashboard</a>
<c:choose>
	<c:when test="${project.id == null}">
		<c:set var="method" value="post"/>
	</c:when>
	<c:otherwise>
		<c:set var="method" value="POST"/>
	</c:otherwise>
</c:choose>
	<div>
		<form:form method="${method}" modelAttribute="project">
			<label>Project Name : </label><form:input path="name" />
			<br>
			<label>Project Description : </label> <form:input path="description" /><br>
			<label>Project Status : </label> 
			<form:select path="status">
				<form:options items="${statusTypes}"  />
			</form:select><br>
			<form:select path="team.id">
				<form:options items="${teams}" itemLabel="text" itemValue="id" />
			</form:select><br>
			<c:choose>
                <c:when test="${project.id == null}">
                    <button type="submit">Create Project</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Project</button>
                </c:otherwise>
            </c:choose>
		</form:form>
	</div>
</body>
</html>
