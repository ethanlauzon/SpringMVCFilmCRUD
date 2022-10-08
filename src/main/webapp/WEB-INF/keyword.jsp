<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<ul>
<c:forEach var = "f" items="${films}">
			<li>"${f.toString()}"</li>
	</c:forEach>
		</ul>
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
</body>
</html>


