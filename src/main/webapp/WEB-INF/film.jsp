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
   <ul>
   <li> Title: ${film.title} </li>
   <li> Description: ${film.description} </li>
   <li> Release Year: ${film.releaseYear} </li>
   <li> Language ID: ${film.languageId} </li>
   <li> Rental Duration: ${film.rentalDuration} </li>
   <li> Rental Rate: ${film.rentalRate} </li>
   <li> Length: ${film.length} </li>
   <li> Replacement Cost: ${film.replacementCost} </li>
   <li> Starring: ${film.actorsInFilm} </li>
   <li> ID: ${film.id} </li>
   </ul>
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