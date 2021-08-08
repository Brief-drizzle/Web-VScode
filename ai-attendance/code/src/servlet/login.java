package servlet;

import java.io.IOException;
import java.util.List;

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



/**
 * Servlet implementation class login_user
 */
@WebServlet("/login")
public class login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		int identity = Integer.parseInt(request.getParameter("identity"));

		ServletContext context = request.getServletContext();
		RootJdbc jdbc = new RootJdbc();
		List<Root> list = jdbc.findAll();
		PeopleJdbc jdbc2 = new PeopleJdbc();
		List<People> list2 = jdbc2.findAll();
		
		boolean flag = false;
		if(identity == 1) {
			for(People p : list2) {
				if(p.getNumber2().equals(name) && password.equals(p.getPassword())) {
					context.setAttribute("pid",p.getId());
					RequestDispatcher dispacher = request.getRequestDispatcher("back.jsp");
			        dispacher.forward(request, response);
			        flag = true;
				}
			}
		}if(identity == 2) {
			for(Root r : list) {
				if(r.getName().equals(name) && r.getPassword().equals(password)) {
					RequestDispatcher dispacher = request.getRequestDispatcher("back_index.jsp");
			        dispacher.forward(request, response);
			        flag = true;
				}
			}
		}
		
		
		if(flag == false) {
			RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
	        dispacher.forward(request, response);
		}

	}

}
