//package com.techdenovo.ujwala;
public class Movie 
{
	private int id;
	private String movieName;
	private String movieDescription;
	private String movieStatus;
	

	public Movie() {
		
		// TODO Auto-generated constructor stub
	}


	public Movie(int id, String movieName, String movieDescription, String movieStatus) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieStatus = movieStatus;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getMovieDescription() {
		return movieDescription;
	}


	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}


	public String getMovieStatus() {
		return movieStatus;
	}


	public void setMovieStatus(String movieStatus) {
		this.movieStatus = movieStatus;
	}

	
}


