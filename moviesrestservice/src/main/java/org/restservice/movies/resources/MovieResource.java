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
@Produces(value={MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MovieResource {
	MovieService movieService = new MovieService();

	@GET
	@Path("/file")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllMoviesFile() {
		File file = new File("C:/data/movies.txt");
		ResponseBuilder respBuilder = Response.status(Status.OK).entity((Object)file);
		respBuilder.header("Content-Disposition", "attachment; filename=demo.txt");
		return respBuilder.build();
	}

	@GET
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@GET
	@Path("/{movieId}")
	public Movie getMovie(@PathParam("movieId") Long movieId) {
		Movie movie = movieService.getMovie(movieId);
		return movie;
	}

	@POST
	//@RolesAllowed("admin")
	public Response addMovie(Movie movie, @Context SecurityContext securityContext) {
		Movie movieAdded = movieService.addMovie(movie);
		return Response.status(Status.CREATED).entity(movieAdded).build();
	}

}

