package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	Film getFilmById(int filmId);

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;

	public List<Film> findFilmByKeyword(String keyword) throws SQLException;

	Film createFilm(Film film) throws SQLException;

	boolean deleteFilm(Film film);

	Film updateFilm(int filmId, Film film);

}
