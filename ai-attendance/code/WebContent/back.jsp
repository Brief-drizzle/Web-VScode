<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>课堂签到系统</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<%
	int flag = 0;
	try{
		flag = Integer.parseInt(request.getParameter("flag"));
	}catch(Exception e){}
	
	if(flag == 1){
%>
	<script>
    alert("测试识别成功！身份认证：李华");
</script>
<%} %>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><class="radius-circle rotate-hover" height="50" alt="" />课堂签到系统</h1>
  </div>
  <div class="head-l">
  	<a class="button button-little bg-red" href="facelogin.jsp" target="right">
  		<!-- <span class="icon-power-off"></span> --> 开启人脸识别</a> </div>
  		<div class="head-l">
  	<a class="button button-little bg-red" href="index.jsp">
  		<!-- <span class="icon-power-off"></span> --> 退出系统</a> </div>
</div>
<hr>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>我的资料</h2>
  <ul>
    <li><a href="student_update.jsp" target="right"><span class="icon-caret-right"></span>个人资料修改</a></li>    
    <li><a href="student_info.jsp" target="right"><span class="icon-caret-right"></span>个人资料查看</a></li>  
  </ul>
   <h2><span class="icon-pencil-square-o"></span>个人签到信息查看</h2>
 <ul>
 	<li><a href="find_student.jsp" target="right"><span class="icon-caret-right"></span>个人签到信息查看</a></li> 
  </ul>  
 

</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
  
    $(".icon-home").click(function(){
	    $("#a_leader_txt").text("所有公告");
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
  
});
</script>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="student_update.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</div>
</body>
</html>