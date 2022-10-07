package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String pass = "student";
	private String user = "student";

	@Override
	public Film getFilmById(int filmId){
		Film film = null;
		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, "
				+ "rental_rate, length, replacement_cost, rating, special_features, language.name FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
//		String user = "student";
//		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, filmId);

			ResultSet filmResult = stmt.executeQuery();

			while (filmResult.next()) {
				film = new Film(findActorsByFilmId(filmResult.getInt("film.id")), filmResult.getInt("film.id"),
						filmResult.getString("title"), filmResult.getString("description"),
						filmResult.getInt("release_year"), filmResult.getInt("language_id"),
						filmResult.getInt("rental_duration"), filmResult.getDouble("rental_rate"),
						filmResult.getInt("length"), filmResult.getDouble("replacement_cost"),
						filmResult.getString("rating"), filmResult.getString("special_features"),
						filmResult.getString("language.name"));

			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return film;
	
	}
	
	

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver");
			throw new RuntimeException("Unable to load MySQL Driver class");
		}
	}



	@Override
	public Actor findActorById(int actorId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Film> findFilmByKeyword(String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Film createFilm(Film film) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean deleteFilm(Film film) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Film updateFilm(int filmId, Film film) {
		// TODO Auto-generated method stub
		return null;
	}

}
