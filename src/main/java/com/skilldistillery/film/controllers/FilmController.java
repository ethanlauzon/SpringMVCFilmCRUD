package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

// test push
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

	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST, params = { "title", "description",
			"releaseYear", "languageId", "rentalDuration", "rentalRate", "length", "replacementCost", "rating" })
	public ModelAndView createFilm(String title, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating, RedirectAttributes redir) {
		Film newFilm = new Film();
		newFilm.setTitle(title);
		newFilm.setDescription(description);
		newFilm.setReleaseYear(releaseYear);
		newFilm.setRating(rating);
		newFilm.setLanguageId(languageId);
		newFilm.setRentalDuration(rentalDuration);
		newFilm.setRentalRate(rentalRate);
		newFilm.setReplacementCost(replacementCost);
		newFilm.setLength(length);
		ModelAndView mv = new ModelAndView();
		Film updatedFilm = filmDao.createDBFilm(newFilm);
		Boolean created;
		if (updatedFilm != null) {
			created = true;
		} else {
			created = false;
		}
		redir.addFlashAttribute("created", created);
		redir.addFlashAttribute("film", updatedFilm);
//		mv.addObject("created", created);
//		mv.addObject("film", updatedFilm);
		mv.setViewName("redirect:filmCreated.do");
		return mv;
	}

	@RequestMapping(path = "filmCreated.do", method = RequestMethod.GET)
	public ModelAndView created() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/updateSuccess.jsp");
		return mv; // redirect to new mapping
	}

	@RequestMapping(path = "editFilm.do", method = RequestMethod.GET, params = "filmId")
	public ModelAndView editFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film edit = filmDao.findFilmById(filmId);
		mv.addObject("film", filmDao.findFilmById(filmId));
		mv.setViewName("WEB-INF/editFilm.jsp");
		return mv;
	}

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST, params = { "filmId", "title", "description",
			"releaseYear", "languageId", "rentalDuration", "rentalRate", "length", "replacementCost", "rating" })
	public ModelAndView modifyFilm(int filmId, String title, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film newFilm = new Film();
		newFilm.setTitle(title);
		newFilm.setDescription(description);
		newFilm.setReleaseYear(releaseYear);
		newFilm.setRating(rating);
		newFilm.setLanguageId(languageId);
		newFilm.setRentalDuration(rentalDuration);
		newFilm.setRentalRate(rentalRate);
		newFilm.setReplacementCost(replacementCost);
		newFilm.setLength(length);
		boolean bool = filmDao.updateFilm(filmId, newFilm);
//		mv.addObject("bool", bool);
//		mv.addObject("film", filmDao.findFilmById(filmId));
//		mv.setViewName("WEB-INF/updateSuccess.jsp");
		redir.addFlashAttribute("bool", bool);
		redir.addFlashAttribute("film", filmDao.findFilmById(filmId));
		mv.setViewName("redirect:filmCreated.do");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST, params = "filmId")
	public ModelAndView deleteFilm(int filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("film", filmDao.findFilmById(filmId));
		boolean bool = filmDao.deleteDBFilm(filmDao.findFilmById(filmId));
//		mv.addObject("delete", bool);
		redir.addFlashAttribute("delete", bool);
		redir.addFlashAttribute("film", filmDao.findFilmById(filmId));
		mv.setViewName("redirect:filmCreated.do");
		return mv;
	}

	@RequestMapping(path = "findFilmByKeyword.do", method = RequestMethod.GET, params = "filmKeyword")
	public ModelAndView searchByKey(String filmKeyword) {
		List<Film> films = filmDao.findFilmByKey(filmKeyword);
		ModelAndView mv = new ModelAndView();
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/keyword.jsp");
		return mv;
	}
}