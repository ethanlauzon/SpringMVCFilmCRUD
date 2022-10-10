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
	<h1>Update Complete</h1>
	<br>
<c:choose>
  <c:when test="${delete == true}">
    <p>Film deleted: ${film.id }</p>
  </c:when>
  <c:when test="${bool == true}">
   <p>Film edited: ${film.id }</p>
  </c:when>
  <c:when test="${created == true}">
   <p>Film created: ${film.id }</p>
  </c:when>
  <c:otherwise>
    <p>No film found.</p>
  </c:otherwise>
</c:choose>
	<a href="index.html">Return</a>
</body>
</html>

