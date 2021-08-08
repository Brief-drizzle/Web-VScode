package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.People;
import entity.Visitor;
import jdbc.PeopleJdbc;
import jdbc.VisitorJdbc;



/**
 * Servlet implementation class login_user
 */
@WebServlet("/visitor_add")
public class visitor_add extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        String path = null;
        //解析和检查请求，是否是post方式，是否是二进制流格式
        Boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return; //如果不是就不用上传了
        } 
        try {
            //创建FileItemFactory对象
            FileItemFactory factory=new DiskFileItemFactory();
            //创建文件上传的处理器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //解析请求
            List<FileItem> items=upload.parseRequest(request);
            //迭代出每一个FileItem
            FileItem name = items.get(0);FileItem sex = items.get(1);FileItem address = items.get(2);FileItem phone = items.get(3);
         
            Visitor v = new Visitor();
            v.setName(name.getString("utf-8"));v.setSex(sex.getString("utf-8"));
            v.setAddress(address.getString("utf-8"));v.setPhone(phone.getString("utf-8"));           
            
            int ran = (int) (Math.random()*(100000000-1)+1); 
            v.setNumber(String.valueOf(ran));
                    
            for (FileItem item : items) {
                String fileName = item.getFieldName();
                if (item.isFormField()) {
                    //普通的表单控件
                    String value = item.getString("utf-8");                   
                    System.out.println(fileName + "->" + value);
                } else {
                    //上传文件的控件
                    System.out.println(fileName + "->" + item.getName()); //一个的标签的name，一个是文件的name
                    item.write(new File("D:/PROJECT/Demo/WebContent/images/", item.getName())); //把上传的文件保存到某个文件中
                    System.out.println(item.getName());
                    path = item.getName();
                }
            } 
            v.setImage(path);
            
            byte[] imgData = FileUtil.readFileByBytes("D:/PROJECT/Demo/WebContent/images/"+path);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr,"UTF-8");
 
            
            FaceAdd.add("zzz",v.getNumber(),imgStr);
 
            VisitorJdbc jdbc = new VisitorJdbc();
            jdbc.AddInfo(v);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        RequestDispatcher dispacher = request.getRequestDispatcher("visitor_add.jsp?flag=1");
        dispacher.forward(request, response);



	}

}
