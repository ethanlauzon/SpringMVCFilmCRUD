<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="updateFilm.do" method="POST">
      <label for="title">Title:</label>
      <input type="text" name="title" value="${film.title }"/>
      <br>
      <label for="description">Description:</label>
      <input type="text" name="description" value="${film.description }"/>
      <br>
      <label for="releaseYear">Release Year:</label>
      <input type="number" name="releaseYear" value="${film.releaseYear }"/>
      <br>
      <label for="language">Language ID:</label>
      <input type="number" name="language" value="${film.language }"/>
      <br>
      <label for="rentalDuration">Rental Duration:</label>
      <input type="number" name="rentalDuration" value="${film.rentalDuration}">
      <br>
      <label for="rentalRate">Rental Rate:</label>
      <input type="number" name="rentalRate" value="${film.rentalRate}">
      <br>
      <label for="length">Length:</label>
      <input type="number" name="length" value="${film.length}">
      <br>
      <label for="replacementCost">Replacement Cost:</label>
      <input type="number" name="replacementCost" value="${film.replacementCost}">
      <br>
      <label for="rating">Rating:</label>
      <input type="text" name="rating" value="${film.rating}">
      <br>
      <label for="specialFeatures">Special Features:</label>
      <input type="text" name="specialFeatures" value="${film.specialFeatures}">
      <br>
      <input type="submit" value="Edit Film">   
      </form>  
  </body>
</html>