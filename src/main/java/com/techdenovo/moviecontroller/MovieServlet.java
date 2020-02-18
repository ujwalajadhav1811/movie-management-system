package com.techdenovo.moviecontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.techdenovo.movieDAO.MovieDao;
import com.techdenovo.moviemanagement.Movie;

/**
 * Servlet implementation class MovieServlet
 */

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao mdDao;
       
    
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   // public void init() {
      //  mdDao = new MovieDao();
   // }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/new":
	                   getAllMovie(request, response);
	                    break;
	                case "/insert":
	                    insertMovie(request, response);
	                    break;
	                case "/delete":
	                    deleteMovie(request, response);
	                    break;
	                case "/edit":
	                   // showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateMovie(request, response);
	                    break;
	                default:
	                    //listUser(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	}
	        
	        private void insertMovie(HttpServletRequest request,HttpServletResponse response) throws IOException {
	        	        int id = Integer.parseInt(request.getParameter("id"));
	        	        String name = request.getParameter("movieName");
	        	        String description = request.getParameter("movieDescription");
	        	        String status = request.getParameter("movieStatus");
	        	        Movie newMovie = new Movie(id,name,description,status);
	        	        mdDao.insertMovie(newMovie);
	        	        response.sendRedirect("list");
	        	    }
	        
     
	        private void updateMovie(HttpServletRequest request, HttpServletResponse response)
	        	    throws SQLException, IOException {
	        	        int id = Integer.parseInt(request.getParameter("id"));
	        	        String name = request.getParameter("Moviename");
	        	        String description = request.getParameter("movieDescription");
	        	        String status = request.getParameter("movieStatus");

	        	        Movie newmovie = new Movie(id, name, description,status);
	        	        mdDao.movieUpdate(newmovie);
	        	        response.sendRedirect("list");
	        	    }
	        private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
	        	    throws SQLException, IOException {
	        	        int id = Integer.parseInt(request.getParameter("id"));
	        	        mdDao.deleteMovie(id);
	        	        response.sendRedirect("list");

	        	    }
	        private void getAllMovie(HttpServletRequest request, HttpServletResponse response)
	        	    throws SQLException, IOException, ServletException {
	        	
	        	        List<Movie> listMovie = mdDao.getAllMovie();
	        	        request.setAttribute("listMovie", listMovie);
	        	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
	        	        dispatcher.forward(request, response);
	        	    }

	    

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
