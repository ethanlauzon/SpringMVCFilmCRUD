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

	<form action="index.html" type="submit" value="return"></form>

	<form action="deleteFilm" method=POST>
		<input type=“hidden” name=“filmId” value=“${film.id}" type="submit">
	</form>
	<br>
	<form action="editFilm.do" method="GET">
		<input type="hidden" name = "filmId" value="${film.id}" type="submit"><br>
	</form>
</body>
</html>