package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load database driver:");
			e.printStackTrace();
			System.err.println("exiting");
			System.exit(1);
		}
	}

	@Override
	public Film createDBFilm(Film film) {
		Connection conn = null;
		String user = "student";
		String pass = "student";

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO film (title, rating, language_id) VALUES (?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, film.getTitle());
			pst.setString(2, film.getRating());
			pst.setInt(3, film.getLanguageId());
			int uc = pst.executeUpdate();
			if (uc == 1) {
				ResultSet filmKeys = pst.getGeneratedKeys();
				if (filmKeys.next()) {
					int newFilmId = filmKeys.getInt(1);
					film.setId(newFilmId);
				}
			} else {
				film = null;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException b) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + film);
		}
		return film;
	}

	@Override
	public boolean deleteDBFilm(Film film) {

		String user = "student";
		String pass = "student";
		String sql = "DELETE FROM film WHERE film.id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, film.getId());

			int uc = pst.executeUpdate();
			if (uc == 1) {
				System.out.println(uc + " film records deleted.");
				return true;
			} else {
				System.out.println("not a valid film");
			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}

	@Override
	public boolean updateFilm(int filmId, Film film) {
		String user = "student";
		String pass = "student";
		String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, "
				+ "rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ?,"
				+ " WHERE film.id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement pst = conn.prepareStatement(sql);
			conn.setAutoCommit(false);

			pst.setString(1, film.getTitle());
			pst.setString(2, film.getDescription());
			pst.setString(3, film.getReleaseYear());
			pst.setInt(4, film.getLanguageId());
			pst.setInt(5, film.getRentalDuration());
			pst.setDouble(6, film.getRentalRate());
			pst.setInt(7, film.getLength());
			pst.setDouble(8, film.getReplacementCost());
			pst.setString(9, film.getRating());
			pst.setString(10, film.getSpecialFeatures());
			int uce = pst.executeUpdate();
			pst.setInt(11, filmId);
			if (uce == 1) {
				System.out.println(uce + " Film Succesfully updated");
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String user = "student";
		String pass = "student";
		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, rental_rate, \n"
				+ "length, replacement_cost, rating, special_features, language.name, category.name\n" + "FROM film\n"
				+ "JOIN language ON language.id = film.language_id\n"
				+ "JOIN film_category ON film_category.film_id = film.id\n"
				+ "JOIN category ON category.id = film_category.category_id\n" + "WHERE film.id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getString("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setName(rs.getString("language.name"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setCategory(rs.getString("category.name"));
				film.setActorsInFilm(findActorsByFilmId(rs.getInt("id")));

			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("e");
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String user = "student";
		String pass = "student";

		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, actorId);
			ResultSet rs = pst.executeQuery();

			ResultSet actorResult = pst.executeQuery();
			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Not a valid id");
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		String user = "student";
		String pass = "student";
		String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, filmId);

			ResultSet rs = pst.executeQuery();

			ResultSet actorResult = pst.executeQuery();
			while (actorResult.next()) {
				Actor actor = new Actor();
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
				actors.add(actor);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return actors;
	}

	@Override
	public List<Film> findFilmByKey(String keywords) {
		List<Film> films = new ArrayList<>();
		String user = "student";
		String pass = "student";
		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, "
				+ "rental_rate, length, replacement_cost, rating, special_features, language.name FROM film "
				+ "JOIN language ON language.id = film.language_id WHERE film.description LIKE ? OR film.title LIKE ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + keywords + "%");
			pst.setString(2, "%" + keywords + "%");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Film film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getString("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setName(rs.getString("language.name"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActorsInFilm(findActorsByFilmId(rs.getInt("id")));
				films.add(film);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("e");
		}
		return films;
	}

}