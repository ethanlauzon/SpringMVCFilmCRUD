<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> Edit Film </h2>
	<h4>Film ID: "${film.id }"</h4>
<form action="updateFilm.do" method="POST">
	
	<br> <input type="hidden" name="filmId" value="${film.id }"/> 
	<br> Title:	<input type="text" name="title" value="${film.title }"/> 
	<br> Description: <input type="text" name="description" value="${film.description }"/> 
	<br> Release Year: <input type="number" name="releaseYear" value="${film.releaseYear }"/>
	<br> Language:<br> <input type="radio" id="languageId" name="languageId" value="1"/>
	<label for="1">English</label><br>
	<input type="radio" id="languageId" name="languageId" value="2"/>
	<label for="2">Italian</label><br>
	<input type="radio" id="languageId" name="languageId" value="3"/>
	<label for="3">Japanese</label><br>
	<input type="radio" id="languageId" name="languageId" value="4"/>
	<label for="4">Mandarin</label><br>
	<input type="radio" id="languageId" name="languageId" value="5"/>
	<label for="5">French</label><br>
	<input type="radio" id="languageId" name="languageId" value="6"/>
	<label for="6">German</label><br>
	
	<br> Rental Duration: <input type="number" name="rentalDuration" value="${film.rentalDuration }"/>
	<br> Rental Rate: <input type="number" name="rentalRate" value="${film.rentalRate }"/>
	<br> Length: <input type="number" name="length" value="${film.length }"/>
	<br> Replacement Cost: <input type="number" name="replacementCost" value="${film.replacementCost }"/>
	<br> Rating: <input type="text" name="rating" value="${film.rating }"/>
	<br> <input type="submit" value="Update" />
	<br>
	
	</form> 
  </body>
</html>