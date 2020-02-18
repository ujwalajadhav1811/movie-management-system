package com.techdenovo.MovieUtility;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
	final String DB_URL="jdbc:mysql://localhost:3306/movie?useTimezone=true&serverTimezone=UTC";
	final String DB_USERNAME="root";
	final String DB_PASSWORD="";
	
	public Connection geConnection() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
	    return con;
	}
	
}

