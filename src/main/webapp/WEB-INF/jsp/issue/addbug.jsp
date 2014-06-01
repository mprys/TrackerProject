<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		
<html>
<body>
<a href="<spring:url value="/" htmlEscape="true" />">Dashboard</a>
<c:choose>
	<c:when test="${bug.id == null}">
		<c:set var="method" value="post"/>
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put"/>
	</c:otherwise>
</c:choose>
	<div>
		<form:form method="${method}" modelAttribute="bug">
			<label>Bug Title : </label><form:input path="title" />
			<br>
			<label>Bug Description : </label><form:textarea path="description"/>
			<br>
			<label>Bug Status :  </label><form:select path="status">
				<form:options items="${statusTypes}" />
			</form:select>
			<br>
			<label>Bug Priority : </label><form:select path="priority">
				<form:options items="${priorityTypes}" />
			</form:select>
			<c:choose>
                <c:when test="${bug.id == null}">
                    <button type="submit">Add Bug</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Bug</button>
                </c:otherwise>
            </c:choose>
		</form:form>
	</div>
</body>
</html>
