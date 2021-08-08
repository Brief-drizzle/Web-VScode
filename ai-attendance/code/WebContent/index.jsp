<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>课堂签到系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Boundary Sign in Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,700' rel='stylesheet' type='text/css'>
</head>
<body style="background:url(images/036.png);background-size:cover">
		<div class="login-form w3-agile">
			<h2>课堂签到系统·系统登录</h2>
			<form action="login" method="post">
					<p>用户名</p>
					<input type="text" name="name" placeholder="请输入用户名/手机号" required="" />
					<p>密码</p>
					<input type="password" name="password" placeholder="请输入密码" required="" />
					<p>登陆身份选择</p>
					<label style="color:white;"><input name="identity" type="radio" value="1" checked="checked"/>学 生 </label> 
					<label style="color:white;"><input name="identity" type="radio" value="2"/>教 师</label>
					<input type="submit" value="系统登录">
			</form>
			
		</div>
</body>
</html>