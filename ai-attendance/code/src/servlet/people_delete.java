package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.PeopleJdbc;



@WebServlet("/people_delete")
public class people_delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		PeopleJdbc jdbc = new PeopleJdbc();
		jdbc.Delete(id);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("back_people.jsp?flag=2");
        dispacher.forward(request, response);
	}

}
