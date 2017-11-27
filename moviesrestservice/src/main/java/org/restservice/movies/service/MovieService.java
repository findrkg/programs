package org.restservice.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.restservice.movies.database.DatabaseClass;
import org.restservice.movies.exception.DataNotFoundException;
import org.restservice.movies.model.Movie;

public class MovieService {

	public Long getLatestVerion() {
		return DatabaseClass.getLatestVerion();
	}

	public List<Movie> getAllMovies(String lang, String year, Long version) {
		List<Movie> list = DatabaseClass.getAllMovies(lang, year, version);
		return list;
	}

	public Movie getMovie(Long movieId) {
		Movie movie = DatabaseClass.getMovie(movieId);
		if (movie == null) {
			throw new DataNotFoundException(movieId + " not found");
		}
		return movie;
	}
	
	public Movie addMovie(Movie movie) {
		DatabaseClass.addMovie(movie);
		return movie;
	}

	public Movie updateMovie(Movie movie) {
		DatabaseClass.updateMovie(movie);
		return movie;
	}

	public void deleteMovie(Long movieId) {
		DatabaseClass.deleteMovie(movieId);
	}
	
}
