package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Worker1;
import jdbc.Worker1Jdbc;



@WebServlet("/worker1_alter")
public class worker1_alter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Worker1Jdbc jdbc = new Worker1Jdbc();
		String sex = request.getParameter("sex");
		String work = request.getParameter("work");
		String phone = request.getParameter("phone");
		
		Worker1 w = jdbc.findByid(id);
		w.setSex(sex);w.setWork(work);w.setPhone(phone);
		
		jdbc.Alter(w);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("back_worker1.jsp?flag=3");
        dispacher.forward(request, response);
	}

}
