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

		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').dataTable();
// 				$('#example_length').hide();
			} );
		</script>
	</head>
<body>
<a href="<spring:url value="/" htmlEscape="true" />">Dashboard</a>
	<div  class="container">

<table class="table table-striped table-bordered" id="example">
	<thead>
		<tr>
			<th>ID</th>
				<th>Name</th>
				<th>Operation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${projects}" var="project" varStatus="counter" >
				<tr class="selected" >
					<td>${counter.index + 1}</td>
					<td>${project.name}</td>
					<td> 
					<a href="<spring:url value="/team/members/${project.id}" htmlEscape="true" />">Add New Members</a> /
					    <a href="<spring:url value="/team/edit/${project.id}" htmlEscape="true" />">Edit</a> / 
						<a href="<spring:url value="/team/remove/${project.id}" htmlEscape="true" />">Remove</a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
</table>

</div>
</body>
</html>
