package Controller; //indicates the class is a part of the 'Controller' package

import java.io.IOException; //imports classes
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.FilmDAO;
import Film.Film;

@WebServlet("/deletefilms")  //annotation
public class deletefilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //gets the value of 'getsid' parameter from the request obect 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("getsid")); //convert it into int
	Film films=new Film(); //creates an object and assigns the id to it
	films.setId(id);
	FilmDAO database=new FilmDAO();
	PrintWriter pw= response.getWriter();
	
	
	
	try {
        database.deleteF(films);
        pw.write("Successfully deleted film"); //uses printwriter to print this message 
    }catch (SQLException e) {
        e.printStackTrace(); //if there is an exception it prints the stack trace of the exception
    }
    pw.close();//closes the PrintWriter object
   
	
}
//defines a doPost method. it handles the POST request made to the servlet and send it to the deletefilms.jsp
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("deletefilms.jsp").include(request,response);

}

}
