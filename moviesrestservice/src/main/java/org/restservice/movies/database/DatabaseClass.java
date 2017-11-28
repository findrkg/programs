package org.restservice.movies.database;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.io.BasicOutputBuffer;
import org.bson.io.OutputBuffer;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.eclipse.persistence.internal.oxm.record.ObjectMarshalContext;
import org.restservice.movies.model.Movie;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBEncoder;
import com.mongodb.DBObject;
import com.mongodb.DefaultDBEncoder;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class DatabaseClass {

	private DBCollection collection = null;
	private static MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
	private static long modCount = 0;

	public static Long getLatestVerion() {
		DB db = dbSingleton.getMoviesdb();
		DBCollection versionCollection = db.getCollection("moviesversion");
		DBObject o = versionCollection.findOne(new BasicDBObject());
		Long laterstVer = (Long)o.get("latestVersion");
		return laterstVer;
	}

	public static List<Movie> getAllMovies(String lang, String year, Long version) {
		DB db = dbSingleton.getMoviesdb();
		DBCollection moviesCollection = db.getCollection("movies");
		BasicDBObject query = new BasicDBObject();
		if(lang != null) {
			query.append("language", lang);
		}
		if(year != null) {
			query.append("year", year);
		}
		if(version != null) {
			query.append("version", new BasicDBObject("$gt", version));
		}

		DBCursor cursor = moviesCollection.find(query).sort(new BasicDBObject("year", -1));
		List<Movie> list = new ArrayList<>();
		try {
			while (cursor.hasNext()) {
				DBObject o = cursor.next();
				Gson gson = new Gson();
		        Movie movie = gson.fromJson(o.toString(), Movie.class);
				list.add(movie);
			}
		}
		finally {
			cursor.close();
		}
		return list;
	}

	public static Movie getMovie(Long movieId) {
		DB db = dbSingleton.getMoviesdb();
		DBCollection moviesCollection = db.getCollection("movies");
		DBObject o = moviesCollection.findOne(new BasicDBObject("id", movieId));		
		Gson gson = new Gson();
		Movie movie = null;
		try {			
	        movie = gson.fromJson(((BasicDBObject)o).toString(), Movie.class);
		}
		catch(JsonSyntaxException ex) {
			ex.printStackTrace();
		}
		return movie;
	}

	public static Movie addMovie(Movie movie) {
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getMoviesdb();
		DBCollection moviesCollection = db.getCollection("movies");
		DBCollection versionCollection = db.getCollection("moviesversion");
		Gson gson = new Gson();
		String jsonString = gson.toJson(movie);
		Document doc = Document.parse(jsonString);
		BasicDBObject docObj = new BasicDBObject(doc);
		moviesCollection.insert(docObj);

		Long size = (Long)moviesCollection.count();
		//update the id
		BasicDBObject query = new BasicDBObject("_id", docObj.getObjectId("_id"));
		BasicDBObject update = new BasicDBObject();
		update.put("$set", new BasicDBObject("id", size).append("version", size));
		moviesCollection.findAndModify(query, update);
		//update the version number	
		if(size == 1) {
			versionCollection.insert(new BasicDBObject("latestVersion", size));
		}
		else {
			BasicDBObject verupdate = new BasicDBObject();
			verupdate.put("$set", new BasicDBObject("latestVersion", size));
			versionCollection.findAndModify(new BasicDBObject(), verupdate);
		}
		return movie;
	}

	public static Movie updateMovie(Movie newMovie) {
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getMoviesdb();		
		DBCollection moviesCollection = db.getCollection("movies");
		Long size = (Long)moviesCollection.count();
		BasicDBObject query = new BasicDBObject("id", newMovie.getId());
		Gson gson = new Gson();		
		String jsonString = gson.toJson(newMovie);
		Document doc = Document.parse(jsonString);
		BasicDBObject update = new BasicDBObject();
		update.put("$set", new BasicDBObject(doc).append("version", size));
		moviesCollection.update(query, update);
		return newMovie;
	}
	
	public static void deleteMovie(Long movieId) {
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getMoviesdb();		
		DBCollection moviesCollection = db.getCollection("movies");
		moviesCollection.remove(new BasicDBObject("id", movieId));
	}

}
