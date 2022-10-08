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

${film.toString()}
<br>

<form action="index.html" type="submit"></form>

<form action="deleteFilm" method="DELETE">
      <input value="${film.id}" type="submit">
      <br>
      </form>
      
      <form action="EditFilm.html" method="EDIT">
      <input value="${film.id}" type="submit">
      <br>
      </form>
</body>
</html>