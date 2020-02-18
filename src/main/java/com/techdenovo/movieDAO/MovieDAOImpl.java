package com.techdenovo.movieDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techdenovo.MovieUtility.DatabaseUtility;
import com.techdenovo.moviemanagement.Movie;



public abstract class MovieDAOImpl implements MovieDao
{
	
	DatabaseUtility dbUtility=new DatabaseUtility();
	public int insertMovie(Movie movie)
	{
		
		try {
          int flag=0;
			Connection con=dbUtility.geConnection();
			
			 String query="INSERT INTO MOVIE(Mname,Description,Status) VALUES(?,?,?)";
			 PreparedStatement st=con.prepareStatement(query);
			 st.setString(1,movie.getMovieName());
			 st.setNString(2,movie.getMovieDescription());
			 st.setString(3,movie.getMovieStatus());
			int response = st.executeUpdate();
			if (response==1)
			{
				flag=1;
			}
			else {
				flag=0;
				}
			con.close();
			return flag;
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	public int movieExist(int id)
	{
		int flag =0;
		
		try {
			
			Connection con=dbUtility.geConnection();
			
			 String query="SELECT * FROM `movie` WHERE id=?";
			 PreparedStatement st=con.prepareStatement(query);
			 
			st.setInt(1,id);
			ResultSet rs=(st.executeQuery());
			
			if (rs.next()) 
				
			{
				flag=1;
	
			}
			else
			{
			flag=0;
			}
			con.close();
		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return flag;
		
		
	}
	public Movie findMovieById(int id)
	{
		Movie movie = new Movie();
		
		try {
			
			Connection con=dbUtility.geConnection();
			
			 String query="SELECT * FROM `movie` WHERE id=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 
			ps.setInt(1,id);
			
			ResultSet rs=(ps.executeQuery());
			
			if (rs.next()) 		
			{
				movie.setId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDescription(rs.getString(3));
				movie.setMovieStatus(rs.getString(4));
	
			}else {
				movie=null;
			}
			con.close();
		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return movie;
		
		
	}
	
	public Movie findMovieByName(String Mname)
	{
		Movie movie = new Movie();
		
		try {
			
			Connection con=dbUtility.geConnection();
			
			 String query="SELECT * FROM `movie` WHERE Mname=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 
			ps.setString(1,Mname);
			
			ResultSet rs=(ps.executeQuery());
			
			if (rs.next()) 		
			{
				movie.setId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDescription(rs.getString(3));
				movie.setMovieStatus(rs.getString(4));
	
			}else {
				movie=null;
			}
			con.close();
		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return movie;
		
		
	}
	public int movieUpdate(Movie movie ) 
	{
		int flag =0;
		try {

			Connection con=dbUtility.geConnection();
			
			 String query="UPDATE `movie` SET `Mname`=?,`Description`=?,`Status`=? WHERE id=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 
			 ps.setString(1,movie.getMovieName());
			 ps.setString(2, movie.getMovieDescription());
			 ps.setString(3,movie.getMovieStatus());
			 ps.setInt(4,movie.getId());
			int rs=(ps.executeUpdate());
			if (rs==1) 
			{
				flag=1;
			}
			else {
				flag=0;
			}
			
			con.close();
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public int movieDelete(Movie movie)
	{
		
		int flag =0;
		try {

			Connection con=dbUtility.geConnection();
			
			 String query="DELETE FROM `movie` WHERE id=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 
			
			 ps.setInt(1,movie.getId());
			int rs=(ps.executeUpdate());
			if (rs==1) 
			{
				flag=1;
			}
			else {
				flag=0;
			}
			
			con.close();
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return flag;
		
		
	}

	public List<Movie> getAllMovie()
	{
		List<Movie>movList=new ArrayList<>();
	
			try {

				Connection con=dbUtility.geConnection();
				 java.sql.Statement ps=con.createStatement();
				String query="SELECT * FROM `movie` "; 
				 
				ResultSet rs=(ps.executeQuery(query));
				java.sql.ResultSetMetaData rsmd=rs.getMetaData();
				while (rs.next())
				{
					Movie m= new Movie();
					m.setId(rs.getInt(1));
					 m.setMovieName(rs.getString(2));
					 m.setMovieDescription(rs.getString(3));
					 m.setMovieStatus(rs.getString(4));
					
					movList.add(m);
				}
				con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
			return movList;

		
	}


	


	



	
		
	}
	
		
	





