package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Visitor;
import jdbc.VisitorJdbc;



@WebServlet("/visitor_alter")
public class visitor_alter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		VisitorJdbc jdbc = new VisitorJdbc();
		Visitor v = jdbc.findByid(id);
		
		v.setSex(sex);v.setAddress(address);v.setPhone(phone);
		jdbc.Alter(v);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("back_visitor.jsp?flag=3");
        dispacher.forward(request, response);
	}

}
