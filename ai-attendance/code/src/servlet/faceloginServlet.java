package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.People;
import entity.Register;
import entity.Visitor;
import entity.Worker1;
import entity.Worker2;
import jdbc.PeopleJdbc;
import jdbc.RegisterJdbc;
import jdbc.VisitorJdbc;
import jdbc.Worker1Jdbc;
import jdbc.Worker2Jdbc;

/**
 * Servlet implementation class faceloginServlet
 */
@WebServlet("/faceloginServlet")
public class faceloginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		PeopleJdbc jdbc = new PeopleJdbc();
		VisitorJdbc jdbc2 = new VisitorJdbc();
		Worker1Jdbc jdbc3 = new Worker1Jdbc();
		Worker2Jdbc jdbc4 = new Worker2Jdbc();
		List<People> list1 = jdbc.findAll();
		List<Visitor> list2 = jdbc2.findAll();
		List<Worker1> list3  = jdbc3.findAll();
		List<Worker2> list4 = jdbc4.findAll();
		
		String path = request.getParameter("imagebast64");
		System.out.println("path=="+path);
		faceSearch f = new faceSearch();
		
		
		List<String> list = f.search(path);
		String user_id = list.get(1);System.out.println("测试信息打印："+user_id);
		/* String score = result.split("")[9];*/
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
		String d = sdf.format(date);
		
		Register r = new Register();
		for(People p : list1) {
			String name =  "\"" + p.getNumber() + "\"";
			if(name.equals(user_id)) {
				System.out.println("测试信息打印："+name);
				r.setDate(d);
				r.setPid(p.getId());
				r.setStatus(1);
				
				r.setS1("您好，本地住户！");
				r.setS2(p.getName());
				r.setS3(p.getPhone());
				r.setS4(p.getAddress());
			}
		}for(Visitor v : list2) {
			String name =  "\"" + v.getNumber() + "\"";
			if(name.equals(user_id)) {
				r.setDate(d);
				r.setPid(v.getId());
				r.setStatus(2);
				
				r.setS1("您好，访客！");
				r.setS2(v.getName());
				r.setS3(v.getPhone());
				r.setS4("访问"+v.getAddress());
			}
		}for(Worker1 w : list3) {
			String name =  "\"" + w.getNumber() + "\"";
			if(name.equals(user_id)) {
				r.setDate(d);
				r.setPid(w.getId());
				r.setStatus(3);
				
				r.setS1("您好，外卖员！");
				r.setS2(w.getName());
				r.setS3(w.getPhone());
				r.setS4(w.getWork());
			}
		}for(Worker2 w : list4) {
			String name =  "\"" + w.getNumber() + "\"";
			if(name.equals(user_id)) {
				r.setDate(d);
				r.setPid(w.getId());
				r.setStatus(4);
				
				r.setS1("您好，快递员！");
				r.setS2(w.getName());
				r.setS3(w.getPhone());
				r.setS4(w.getWork());
			}
		}
		
		System.out.println("身份打印"+r.getPid()+r.getS1()+r.getS2());
		RegisterJdbc jdbc5 = new RegisterJdbc();
		if(r.getS1() != null) {
			jdbc5.AddInfo(r);
		}
		
		
		context.setAttribute("user",r);
		
		System.out.println("分数打印："+list.get(2));
		
		/*int score = Integer.parseInt(list.get(2));System.out.println("分数打印："+score);*/
		/*if(score >= 72) {
			RequestDispatcher dispacher = request.getRequestDispatcher("result.jsp?flag=1");
	        dispacher.forward(request, response);
		}else {
			RequestDispatcher dispacher = request.getRequestDispatcher("result.jsp?flag=2");
	        dispacher.forward(request, response);
		}*/
		//输出
		PrintWriter out = response.getWriter() ;
		out.write(list.get(2));//注意这里向jsp输出的流，在script中的截获方法
		out.flush();
		out.close();
	}

}
