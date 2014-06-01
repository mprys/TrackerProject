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

		<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" language="javascript" src="//cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" language="javascript" src="//cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
	
	
	
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').dataTable();
			} );
		</script>
	</head>
<body>
<a href="<spring:url value="/" htmlEscape="true" />">Dashboard</a>
	<div  class="container">

<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
	<thead>
		<tr>
			<th>ID</th>
				<th>Name</th>
				<th>Create Date</th>
				<th>Operation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${developerList}" var="developer" >
				<tr class="odd gradeX">
					<td>${developer.id}</td>
					<td>${developer.name}</td>
					<td>${developer.createDate}</td>
					<td><a href="<spring:url value="/developer/edit/${developer.id}" htmlEscape="true" />">Edit</a> / 
						<a href="<spring:url value="/developer/remove/${developer.id}" htmlEscape="true" />">Remove</a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
</table>

</div>
</body>
</html>
