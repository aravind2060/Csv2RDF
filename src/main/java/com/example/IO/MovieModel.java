package com.example.IO;

public class MovieModel {

	private String actor;
	private String movie;
	private String country;
	
	public MovieModel() {
		super();
	}
	
	public MovieModel(String actor, String movie, String country) {
		super();
		this.actor = actor;
		this.movie = movie;
		this.country = country;
	}

	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
