package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmByKey(String keywords);
	
	public Film createDBFilm(Film film);
	
	public boolean deleteDBFilm(Film film);
	
	Film updateFilm(int filmId, Film film);
}
