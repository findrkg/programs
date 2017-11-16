package org.restservice.movies.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.glassfish.jersey.internal.util.Base64;
import org.jose4j.json.internal.json_simple.JSONObject;


public class RestClient {

	private String jwtToken;

	public void getAllMovies() {
		URL url = null;
		HttpURLConnection urlConnection = null;
		String basicAuth = null;
		try {
			url = new URL("http://localhost:8081/moviesrestservice/webapi/movies");
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Accept", "application/json");
			urlConnection.setRequestProperty("Content-Type", "application/json");
			if(jwtToken != null) {
				basicAuth = "Bearer " + jwtToken;
			}
			else {
				String userPass = "restmovies@gmail.com:restmovies";
				basicAuth = "Basic " + Base64.encodeAsString(userPass.getBytes());				
			}
			urlConnection.setRequestProperty("Authorization", basicAuth);
			urlConnection.connect();
			
			if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ urlConnection.getResponseCode());
			}

			jwtToken = urlConnection.getHeaderField("jwt");
			BufferedReader br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(urlConnection != null) {
				urlConnection.disconnect();				
			}
		}
	}

	public void addMovie() {
		URL url = null;
		String basicAuth = null;
		try {
			url = new URL("http://localhost:8081/moviesrestservice/webapi/movies");
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "application/json");

			if(jwtToken != null) {
				basicAuth = "Bearer " + jwtToken;
			}
			else {
				String userPass = "restmovies@gmail.com:restmovies";
				basicAuth = "Basic " + Base64.encodeAsString(userPass.getBytes());				
			}
			urlConnection.setRequestProperty("Authorization", basicAuth);
			
			JSONObject json = new JSONObject();
			json.put("name", "testing123");
			json.put("director", "rohit123");
			json.put("leadActor", "raj");
			json.put("leadActoress", "hema");
			String jsonString = json.toJSONString();

	        OutputStream os = urlConnection.getOutputStream();
	        os.write(jsonString.getBytes());
	        os.flush();
	        os.close();
			urlConnection.connect();
			
			if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ urlConnection.getResponseCode());
			}

			jwtToken = urlConnection.getHeaderField("jwt");
			BufferedReader br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			urlConnection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RestClient client = new RestClient();
		client.getAllMovies();
		//client.getAllMovies();
		//client.addMovie();
	}
}
