package org.restservice.movies.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	private long id;
	private String title;
	private String language;
	private long version;
	private Hints hints;

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
	public Hints getHints() {
		return hints;
	}
	public void setHints(Hints hints) {
		this.hints = hints;
	}

}
