<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<body>
<a href="<spring:url value="/" htmlEscape="true" />">Dashboard</a>
<c:choose>
	<c:when test="${developer.id == null}">
		<c:set var="method" value="post"/>
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put"/>
	</c:otherwise>
</c:choose>
	<div>
		<form:form method="${method}" modelAttribute="developer">
			<label>Developer Name : </label><form:input path="name" />
			<br>
			<c:choose>
                <c:when test="${developer.id == null}">
                    <button type="submit">Add Developer</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Developer</button>
                </c:otherwise>
            </c:choose>
		</form:form>
	</div>
</body>
</html>
