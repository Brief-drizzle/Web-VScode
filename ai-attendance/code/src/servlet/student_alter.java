package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.People;
import entity.Root;
import jdbc.PeopleJdbc;
import jdbc.RootJdbc;



@WebServlet("/student_alter")
public class student_alter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		ServletContext context = request.getServletContext();
		int pid = (Integer)context.getAttribute("pid");
		
		PeopleJdbc jdbc = new PeopleJdbc();
		People p = new People();
		
		p.setId(pid);p.setPhone(phone);p.setPassword(password);
		jdbc.Alter(p);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("student_update.jsp?flag=1");
        dispacher.forward(request, response);
	}

}
