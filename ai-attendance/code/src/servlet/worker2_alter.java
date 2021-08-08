package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Worker2;
import jdbc.Worker2Jdbc;



@WebServlet("/worker2_alter")
public class worker2_alter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		
		String sex = request.getParameter("sex");
		String work = request.getParameter("work");
		String phone = request.getParameter("phone");
		
		Worker2Jdbc jdbc = new Worker2Jdbc();
		Worker2 w = jdbc.findByid(id);
		
		w.setSex(sex);w.setWork(work);w.setPhone(phone);
		
		jdbc.Alter(w);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("back_worker2.jsp?flag=3");
        dispacher.forward(request, response);
	}

}
