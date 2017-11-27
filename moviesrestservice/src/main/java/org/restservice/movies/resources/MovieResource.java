package org.restservice.movies.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.restservice.movies.model.Movie;
import org.restservice.movies.service.MovieService;

@Path("movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value={MediaType.APPLICATION_JSON})
public class MovieResource {
	MovieService movieService = new MovieService();

	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public Long getLatestVerion() {
		return movieService.getLatestVerion();
	}

	@GET
	public List<Movie> getAllMovies(@QueryParam("language") String lang, 
			@QueryParam("year") String year, @QueryParam("version") Long version) {
		return movieService.getAllMovies(lang, year, version);
	}
	
	@GET
	@Path("/{movieId}")
	public Movie getMovie(@PathParam("movieId") Long movieId) {
		Movie movie = movieService.getMovie(movieId);
		return movie;
	}

	@POST
	//@RolesAllowed("admin")
	public Movie addMovie(Movie movie) {
		Movie movieAdded = movieService.addMovie(movie);
		return movieAdded;
	}

	@PUT
	@Path("/{movieId}")
	public Movie updateMovie(Movie movie) {
		Movie updatedMovie = movieService.updateMovie(movie);
		return updatedMovie;
	}

	@DELETE
	@Path("/{movieId}")
	public Response deleteMovie(@PathParam("movieId") Long movieId) {
		movieService.deleteMovie(movieId);
		return Response.status(Status.OK).build();
	}

}

