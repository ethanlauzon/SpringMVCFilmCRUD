<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films results</title>
</head>
<title>Films with matching titles/keywords</title>
<body>
<c:forEach items="${film}">
		<ul>
			<li>"${film.toString()}"</li>
			<br>
		</ul>
	</c:forEach>
	<br>
	<div>
	<form action="deleteFilm.do" method=POST>
	Enter ID to delete film:
		<input type="number" name="filmId">
		<input type="submit" value="delete">
	</form>
	<br>
	<form action="editFilm.do" method="GET">
	Film ID to edit film:
		<input type="number" name="filmId">
		<input type="submit" value="edit">
	</form>
	</div>
</body>
</html>
