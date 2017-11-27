package org.restservice.movies.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Movie {
	private long id;
	private String title;
	private String actor;
	private String actoress;
	private String director;
	private String year;
	private String language;
	private long version;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActoress() {
		return actoress;
	}
	public void setActoress(String actoress) {
		this.actoress = actoress;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}

}
