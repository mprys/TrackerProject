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
		<c:forEach items="${teams}" var="team" varStatus="counter" >
				<tr class="selected" >
					<td>${counter.index + 1}</td>
					<td>${team.name}</td>
					<td> <a data-toggle="modal" href="<spring:url value="/team/members/${team.id}" htmlEscape="true" />" data-target="#myModal">Click me --</a>
					<a href="<spring:url value="/team/members/${team.id}" htmlEscape="true" />">Add New Members</a> /
					    <a href="<spring:url value="/team/edit/${team.id}" htmlEscape="true" />">Edit</a> / 
						<a href="<spring:url value="/team/remove/${team.id}" htmlEscape="true" />">Remove</a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
</table>


<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"  aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
     
    </div>
  </div>
</div>


<a data-toggle="modal" href="http://fiddle.jshell.net/bHmRB/22/show/" data-target="#myModal">Click me !</a>

<!-- Modal -->
<div class="modal fade bs-example-modal-lg" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                 <h4 class="modal-title">Modal title</h4>
            </div>
            <div class="modal-body"><div class="te"></div></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

</div>
</body>
</html>
