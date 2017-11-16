package org.restservice.movies.database;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.restservice.movies.model.Movie;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DatabaseClass {

	private DBCollection collection = null;
	private static MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();

	public static List<Movie> getAllMovies() {		
		DB db = dbSingleton.getMoviesdb();
		DBCollection collection = db.getCollection("movies");
		DBCursor cursor = collection.find().sort(new BasicDBObject("by", 1));
		List<Movie> list = new ArrayList<>();
		while (cursor.hasNext()) {
			DBObject o = cursor.next();
			Movie movie = new Movie();
			movie.setId((Long)o.get("id"));
			movie.setName((String) o.get("name"));
			movie.setYear((String) o.get("year"));
			movie.setDirector((String) o.get("director"));
			movie.setLeadActor((String) o.get("lead_actor"));
			movie.setLeadActoress((String) o.get("lead_actoress"));
			list.add(movie);
		}
		return list;
	}

	public static Movie getMovie(Long movieId) {
		DB db = dbSingleton.getMoviesdb();
		DBCollection collection = db.getCollection("movies");
		DBObject o = collection.findOne(new BasicDBObject("id", movieId));
		Movie movie = null;
		if(o != null) {
			movie = new Movie();
			movie.setId(movieId);
			movie.setName((String) o.get("name"));
			movie.setYear((String) o.get("year"));
			movie.setDirector((String) o.get("director"));
			movie.setLeadActor((String) o.get("lead_actor"));
			movie.setLeadActoress((String) o.get("lead_actoress"));		
		}
		return movie;
	}

	public static Movie addMovie(Movie movie) {
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getMoviesdb();		
		DBCollection collection = db.getCollection("movies");

		BasicDBObject document = new BasicDBObject();
		document.put("id", (Long)collection.count()+1);
		document.put("name", movie.getName());
		document.put("year", movie.getYear());
		document.put("director", movie.getDirector());
		document.put("lead_actor", movie.getLeadActor());
		document.put("lead_actoress", movie.getLeadActoress());
		collection.insert(document);
		return movie;
	}

}
