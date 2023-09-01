package Controller;

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


@WebServlet("/Addfilms")
public class Addfilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Addfilms() {  //constructor for a class called AddFilms. its public and takes no arguments. 
        super(); //it calls the constructor of the super class using the super() method. 
        
    }

	/*This is a method called doGet in the class httpservlet */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //takes 2 paramaters.the web server calls this when a get GET request is made to the servlet. 
			request.getRequestDispatcher("Addfilms.jsp").include(request, response); //includes a request and response to the 'Addfilms.jsp'page 
	}

	//this also defines a method called 'doPost' in the httpservlet class
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");//*gets values of multiple parameters from the request object. title, director,review, stars and year using the getParameter() method
		String director=request.getParameter("director");
		String review=request.getParameter("review");
		String stars=request.getParameter("stars");
		int year=Integer.parseInt(request.getParameter("year"));
		Film films=new Film(07,title,year,director,stars,review);//creates an object of Film class with the values and an id of 07
		FilmDAO f=new FilmDAO(); 
		PrintWriter out =response.getWriter(); //I used a PrintWriter object to write a message 'successfully inserted film, if its successful
		
		try {
            f.insertF(films);
            out.write("Successfully inserted film");
        }catch (SQLException e) {
            e.printStackTrace(); //if there is an exception it prints the stack trace of the exception
        }
        out.close();  //closes a PrintWriter object
    }

		
	

}
