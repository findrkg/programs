package org.restservice.movies.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	long id;
	String name;
	String leadActor;
	String leadActoress;
	String director;
	String year;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeadActor() {
		return leadActor;
	}
	public void setLeadActor(String actor) {
		this.leadActor = actor;
	}
	public String getLeadActoress() {
		return leadActoress;
	}
	public void setLeadActoress(String actoress) {
		this.leadActoress = actoress;
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
	
}
