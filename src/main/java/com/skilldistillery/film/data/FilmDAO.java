package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmByKey(String keywords);
	
	public Film createDBFilm(Film film);
	
	public boolean deleteDBFilm(Film film);
	
	Film updateFilm(int filmId, Film film);

}