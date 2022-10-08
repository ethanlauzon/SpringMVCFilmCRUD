package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.film.data.FilmDaoJdbcImpl;
import com.skilldistillery.film.entities.Film;

public class FilmQueryApp {

	FilmDaoJdbcImpl db = new FilmDaoJdbcImpl();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
		app.launch();
	}

	private void test() throws SQLException {
//    Film film = db.findFilmById(1);
//    Actor film2 = db.findActorById(1);
//    List<Actor> actors = db.findActorsByFilmId(474);
//		for (Actor actor : actors) {
//			System.out.println(actor);
//		}
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);
		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		boolean loopMenu = true;
		int input1;
		while (loopMenu) {
			menu();
			try {
				input1 = input.nextInt();
				input.nextLine();
				switch (input1) {
				case 1:
					filmById(input);
					System.out.println();
					continue;
				case 2:
					filmByKeyword(input);
					System.out.println();
					continue;
				case 3:
					Film newFilm = db.createDBFilm(createFilm(input));
					System.out.println("Film created: " + newFilm.getId());
					continue;
				case 4:
					db.deleteDBFilm(deleteFilm(input));
					System.out.println("in delete case 4");
					continue;
				case 5:
					System.out.println("All out of popcorn?");
					loopMenu = false;
					break;
				default:
					System.out.println("invalid entry");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid number.\n");
				input = new Scanner(System.in);
				continue;
			}
		}
	}

	private void filmById(Scanner input) throws SQLException {
		System.out.println("Enter a film id");
		int filmId = input.nextInt();
		Film result = db.findFilmById(filmId);
		if (result != null) {
			System.out.println(result);
			subMenu(result, input);
		} else {
			System.out.println("No match found.");
		}
	}

	private void filmByKeyword(Scanner input) {
		System.out.println("Type in a keyword to search films:");
		String filmKey = input.next();
		List<Film> result = db.findFilmByKey(filmKey);

		if (result.size() == 0) {
			System.out.println("No films match the keywords.");
		} else {
			for (Film film : result) {
				System.out.println(film);
				System.out.println();
			}
			System.out.println("Here are " + result.size() + " films related to the keywords.");
		}
	}

	private void menu() {
		System.out.println("Select an option:");
		System.out.println("1 - Look up a film by its id");
		System.out.println("2 - Look up a film by a search keyword");
		System.out.println("3 - Create a film");
		System.out.println("4 - Delete a film");
		System.out.println("5 - Exit the application");
	}

	private void subMenu(Film film, Scanner input) {
		System.out.println("\nSelect an option:");
		System.out.println("1 - View all film details");
		System.out.println("2 - Return to the main menu");
		System.out.println("3 - Delete Film");
		Scanner kb = new Scanner(System.in);
		int userInput = kb.nextInt();
		switch (userInput) {
		case 1:
			System.out.println(film.printDetailsString());
			break;
		case 2:
			System.out.println("Returning to main menu...");
			break;
		case 3:
			System.out.println("Deleting film");
			db.deleteDBFilm(deleteFilm(input));
			break;
		}
	}

	private Film createFilm(Scanner input) {
		System.out.println("Enter title: ");
		String filmTitle = input.nextLine();
		
		System.out.println("Enter film rating: ");
		String filmRating = input.nextLine();
		System.out.println(
				"Enter film language (1 = English, 2 = Italian, 3 = Japanese, 4 = Mandarin, 5 = French, 6 = German): ");
		int language = input.nextInt();
		Film userFilm = new Film();
		userFilm.setTitle(filmTitle);
		userFilm.setRating(filmRating);
		userFilm.setLanguageId(language);
		return userFilm;
	}
	
	private Film deleteFilm(Scanner input) {
		System.out.println("Enter a film ID to delete: ");
		int id = input.nextInt();
		Film deleteFilm = new Film();
		deleteFilm.setId(id);
		return deleteFilm;
	}
}
