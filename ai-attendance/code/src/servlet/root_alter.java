package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.People;
import entity.Root;
import jdbc.PeopleJdbc;
import jdbc.RootJdbc;



@WebServlet("/root_alter")
public class root_alter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		RootJdbc jdbc = new RootJdbc();
		Root r = new Root();
		
		r.setId(1);r.setName(name);r.setPassword(password);
		jdbc.Alter(r);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("root_update.jsp?flag=1");
        dispacher.forward(request, response);
	}

}
