<%@page import="entity.People"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>社区人脸识别登记系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Boundary Sign in Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,700' rel='stylesheet' type='text/css'>
</head>
<jsp:useBean id="Jdbc" class="jdbc.PeopleJdbc" scope="page"></jsp:useBean>
<%
ServletContext context = request.getServletContext();
int pid = (Integer)context.getAttribute("pid");
People p = Jdbc.findByid(pid);

%>
<body style="background:url(images/036.png);background-size:cover">
		<div class="login-form w3-agile">
			<h2>社区人脸识别系统·本地住户个人信息</h2>
			<form action="register" method="post" enctype="multipart/form-data">
					<p>姓 名</p>
						<h3 style="color:white"><%=p.getName() %></h3>
					<p>性别</p>
						<h3 style="color:white"><%=p.getSex() %></h3>
					<p>联系电话</p>
					<h3 style="color:white"><%=p.getPhone() %></h3>
					<p>地 址</p>
					<h3 style="color:white"><%=p.getAddress() %></h3>
					
					
			</form>
			<a href="index.jsp">返回登录页面</a>
		</div>
</body>
</html>