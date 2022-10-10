<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Keyword results</title>
</head>
<body>
<h2>Related films</h2>
	<form action="deleteFilm.do" method=POST>
	Enter film ID to delete:
		<input type="number" name="filmId">
		<input type="submit" value="delete">
	</form>
	<br>
	<form action="editFilm.do" method="GET">
	Enter film ID to edit:
		<input type="number" name="filmId">
		<input type="submit" value="edit">
	</form>
		<ul>
<c:forEach var = "f" items="${films}">
   <br>
 	<li><strong> Title: ${f.title}</strong> </li>
   <li> Description: ${f.description} </li>
   <li> Release Year: ${f.releaseYear} </li>
   <li> Language ID: ${f.languageId} </li>
   <li> Rental Duration: ${f.rentalDuration} </li>
   <li> Rental Rate: ${f.rentalRate} </li>
   <li> Length: ${f.length} </li>
   <li> Replacement Cost: ${f.replacementCost} </li>
   <li> Starring: ${f.actorsInFilm} </li>
   <li> ID: ${f.id} </li>
   <br>
	</c:forEach>
		</ul>
</body>
</html>