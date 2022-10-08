package com.skilldistillery.film.controllers;

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
	public ModelAndView showFilm(Integer filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
	public ModelAndView createFilm() {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.createDBFilm();
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
	public ModelAndView addFilm() {
		ModelAndView mv = new ModelAndView();

	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
	public ModelAndView updateFilm() {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.updateFilm(0, null);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
	public ModelAndView deleteFilm() {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.deleteDBFilm(null);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/film.jsp");
		return mv;
	}

	@RequestMapping(path = " ", method = RequestMethod.GET, params = " ")
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
