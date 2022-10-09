<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<h1>Update Status</h1>
	<br>
	<c:choose>
  <c:when test="${bool == true}">
   <p>Film updated.
  Film ID: ${film.id }</p>
  </c:when>
  <c:otherwise>
    <p>Film not updated.</p>
  </c:otherwise>
</c:choose>

	<a href="index.html">Return</a>
</body>
</html>