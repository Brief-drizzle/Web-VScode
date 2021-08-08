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
import entity.Visitor;
import entity.Worker1;
import entity.Worker2;
import jdbc.PeopleJdbc;
import jdbc.VisitorJdbc;
import jdbc.Worker1Jdbc;
import jdbc.Worker2Jdbc;



@WebServlet("/find")
public class find extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int identity = Integer.parseInt(request.getParameter("identity"));
		String name = request.getParameter("name");
		
		PeopleJdbc jdbc = new PeopleJdbc();
		VisitorJdbc jdbc2 = new VisitorJdbc();
		Worker1Jdbc jdbc3 = new Worker1Jdbc();
		Worker2Jdbc jdbc4 = new Worker2Jdbc();
		List<People> list1 = jdbc.findAll();
		List<Visitor> list2 = jdbc2.findAll();
		List<Worker1> list3  = jdbc3.findAll();
		List<Worker2> list4 = jdbc4.findAll();
		int pid=0;
		if(identity == 1) {
			for(People p : list1) {
				if(p.getName().equals(name)) {
					pid = p.getId();
				}
			}
		}if(identity == 2) {
			for(Visitor v : list2) {
				if(v.getName().equals(name)) {
					pid = v.getId();
				}
			}
		}if(identity == 3) {
			for(Worker1 w : list3) {
				if(w.getName().equals(name)) {
					pid = w.getId();
				}
			}
		}if(identity == 4) {
			for(Worker2 w : list4) {
				if(w.getName().equals(name)) {
					pid = w.getId();
				}
			}
		}
		
		ServletContext context = request.getServletContext();
		context.setAttribute("pid",pid);
		context.setAttribute("identity",identity);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("find_result.jsp");
        dispacher.forward(request, response);
	}

}
