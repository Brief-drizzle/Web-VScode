package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.People;
import jdbc.PeopleJdbc;



@WebServlet("/people_alter")
public class people_alter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		System.out.println("sex=="+sex);
		
		PeopleJdbc jdbc = new PeopleJdbc();
		People p = jdbc.findByid(id);
		
		p.setSex(sex);p.setAddress(address);p.setPhone(phone);
		jdbc.Alter(p);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("back_people.jsp?flag=3");
        dispacher.forward(request, response);
	}

}
