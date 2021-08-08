package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Worker2Jdbc;



@WebServlet("/worker_delete2")
public class worker_delete2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Worker2Jdbc jdbc = new Worker2Jdbc();
		jdbc.Delete(id);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("back_worker2.jsp?flag=2");
        dispacher.forward(request, response);
	}

}
