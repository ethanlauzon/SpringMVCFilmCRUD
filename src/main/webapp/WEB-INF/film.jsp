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
	<p>${film.toString()}</p>
	<br>

	<form action="deleteFilm.do" method=POST>
		<input type="number" hidden="true" name="filmId" value="${film.id }">
		<input type="submit" value="delete">
	</form>
	<br>
	<form action="editFilm.do" method="GET">
		<input type="number" hidden="true" name="filmId" value="${film.id }">
		<input type="submit" value="edit">
	</form>
	<br>
	<a href="index.html">Return</a>
</body>
</html>