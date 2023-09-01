package Controller; //shows that the class is part of the 'Controller' package

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.FilmDAO;
import Film.Film;

@WebServlet("/UpdateFilms")
public class UpdateFilms extends HttpServlet {
	public static int id;
	
	
	private static final long serialVersionUID = 1L;
       
   //retrieves the value of 'getsid' parameter from the request using the getParameter() methof
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title=request.getParameter("title");//retreives values of title, director, stars review and year
		String director=request.getParameter("director");
		String review=request.getParameter("review");
		String stars=request.getParameter("stars");
		
		int year=Integer.parseInt(request.getParameter("year"));
		Film films=new Film(id,title,year,director,stars,review);
		films.setId(id);
		FilmDAO database=new FilmDAO(); //creates this to interact with the database
		PrintWriter pw= response.getWriter(); //writes a message to the respons eobject 
		
		
		
		try {
            database.updateF(films);
            pw.write("Successfully updated films"); //I used printWriter to output the message if it is successful
        }catch (SQLException e) { //if an exception occurs it prints the stack trace of the exception
            e.printStackTrace();
        }
        pw.close(); //closes the printWriter
       
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  id=Integer.parseInt(request.getParameter("updatesfilm"));
		
		
		
		
	request.getRequestDispatcher("Update.jsp").include(request,response);
	
	}
	
	
	
	
	

	

}
