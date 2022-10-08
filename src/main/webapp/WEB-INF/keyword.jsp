<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="f" items="${film}">
		<ul>
			<li>"${f.toString()}"</li>
		</ul>
		<form action="deleteFilm" method="DELETE">
      <input value="${f.id}" type="submit">
      <br>
        <form action="editFilm" method="EDIT">
      <input value="${f.id}" type="submit">
      </form>
      <br>
      </form>
	</c:forEach>
</body>
</html>


