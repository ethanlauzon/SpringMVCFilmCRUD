package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;

import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = "showFilm.do", method = RequestMethod.GET, params = "filmId")
	public ModelAndView showFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

	@RequestMapping(path = "NewFilmForm.html", method = RequestMethod.POST, params = " ")
	public ModelAndView createFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDao.createDBFilm(film));
		
		return mv;
	// create jsp for success
	}

	@RequestMapping(path = "editFilm.do", method = RequestMethod.GET, params = "filmId")
	public ModelAndView editFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDao.findFilmById(filmId)); 
		mv.setViewName("WEB-INF/editFilm.jsp");
		return mv;
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = "filmId")
	public ModelAndView getInfoToUpdate(int Id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(0, null);
		// find film
		mv.addObject("title", film.getTitle());
		mv.addObject("description", film.getDescription());
		mv.setViewName("WEB-INF/editFilm.html");
		return mv;
	}
	
	

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST, params = "filmId")
	public ModelAndView modifyFilm(int filmId, String title, String description, String releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			String name, String category) {
		
		ModelAndView mv = new ModelAndView();
		
		Film newFilm = new Film(0, title, description, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, null, name, category);
		filmDao.updateFilm(filmId, newFilm);
		mv.setViewName("WEB-INF/updateSuccess.jsp");
		

		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST, params = "filmId")
	public ModelAndView deleteFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		boolean delete = filmDao.deleteDBFilm(filmDao.findFilmById(filmId));
		mv.addObject("film", filmDao.findFilmById(filmId));
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}
	@RequestMapping(path = "deleteFilm ", method = RequestMethod.GET, params = " ")
	public ModelAndView deleteFilm() {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.deleteDBFilm(null);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

	@RequestMapping(path = "findFilmByKeyword ", method = RequestMethod.GET, params = " ")
	public ModelAndView searchByKey() {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmByKey(null);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
	public ModelAndView searchById() {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(0);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

}
