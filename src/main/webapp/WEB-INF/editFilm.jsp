<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Edit Film </h2>
Film ID: ${film.id } <br>
<form action="updateFilm.do" method="POST">
	<br> Title:	<input type="text" name="title" value="${film.title }"/> 
	<br> Description: <input type="text" name="description" value="${film.description }"/> 
	<br> Release Year: <input type="text" name="releaseYear" value="${film.releaseYear }"/>
	<br> Language ID: <input type="text" name="languageId" value="${film.languageId }"/>
	<br> Rental Duration: <input type="text" name="rentalDuration" value="${film.rentalDuration }"/>
	<br> Rental Rate: <input type="text" name="rentalRate" value="${film.rentalRate }"/>
	<br> Length: <input type="text" name="length" value="${film.length }"/>
	<br> Replacement Cost: <input type="text" name="replacementCost" value="${film.replacementCost }"/>
	<br> Rating: <input type="text" name="rating" value="${film.rating }"/>
	<input type="number" hidden="true" name="filmId" value="${film.id }">
	<br> <input type="submit" value="Update" />
	</form><br>
	
	</form> 
  </body>
</html>