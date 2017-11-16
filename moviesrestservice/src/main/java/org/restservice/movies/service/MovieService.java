package org.restservice.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.restservice.movies.database.DatabaseClass;
import org.restservice.movies.exception.DataNotFoundException;
import org.restservice.movies.model.Movie;

public class MovieService {
	
	public List<Movie> getAllMovies() {
		List<Movie> list = DatabaseClass.getAllMovies();
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
	
//	public Message updateMessage(Movie movie) {
//		if (message.getId() <= 0) {
//			return null;
//		}
//		messages.put(message.getId(), message);
//		return message;
//	}
//	
//	public Message removeMessage(long id) {
//		return messages.remove(id);
//	}
}
