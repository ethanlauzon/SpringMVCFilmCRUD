<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Details</title>
</head>
<body>
	<h1>Film Details</h1>
	<c:choose>
    <c:when test="${!empty film}">
   <p>
  ${film.printDetailsString()}</p>
  </c:when>
  
  <c:otherwise>
    <p>No film found.</p>
  </c:otherwise>
</c:choose>
	

	<form action="index.html" type="submit" value="return"></form>

	<form action="deleteFilm.do" method=POST>
		<input type="number" hidden="true" name="filmId" value="${film.id }">
		<input type="submit" value="delete">
	</form>
	<br>
	<form action="editFilm.do" method="GET">
		<input type="number" hidden="true" name="filmId" value="${film.id }">
		<input type="submit" value="edit">
	</form>
</body>
</html>