package com.techdenovo.movieDAO;

import java.util.List;

import org.apache.catalina.User;

import com.techdenovo.moviemanagement.Movie;

public interface MovieDao
{
	public int insertMovie(Movie movie);
	public List<Movie> getAllMovie();
	public int movieUpdate(Movie movie );
	public void deleteMovie(int id);
		
	
}


