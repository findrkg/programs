package org.restservice.movies.database;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoDBSingleton {

	private static MongoDBSingleton mDbSingleton;

	private static MongoClient mongoClient;

	private static DB db;

	private static final String dbHost = "localhost";
	private static final int dbPort = 27017;
	private static final String dbName = "moviesdb";
	private static final String dbUser = "moviesadmin";
	private static final String dbPassword = "moviesadmin";

	private MongoDBSingleton() {
	};

	public static MongoDBSingleton getInstance() {
		if (mDbSingleton == null) {
			mDbSingleton = new MongoDBSingleton();
		}
		return mDbSingleton;
	}

	public DB getMoviesdb() {
		boolean auth = false;
        // create user with username,password and specify the database name
        MongoCredential credential = MongoCredential.createCredential(
                "moviesadmin", "moviesdb", "moviesadmin".toCharArray());
 
        // create an instance of mongoclient
        MongoClient mongoClient = null;
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));		
//		if (mongoClient == null) {
//			try {
//				mongoClient = new MongoClient(dbHost, dbPort);
//			} catch (UnknownHostException e) {
//				return null;
//			}
//		}
		if (db == null)
			db = mongoClient.getDB(dbName);
		return db;
	}
}