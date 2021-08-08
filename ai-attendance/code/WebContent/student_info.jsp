<%@page import="entity.People"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<jsp:useBean id="Jdbc" class="jdbc.PeopleJdbc" scope="page"></jsp:useBean>
<%
	ServletContext context = request.getServletContext();
	int pid = (Integer)context.getAttribute("pid");
	People p = Jdbc.findByid(pid);
%>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>学生个人信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="root_alter">
      <div class="form-group">
        <div class="label">
          <label for="sitename">学号：</label>
        </div>
        <div class="field">
          <%=p.getNumber2() %>   
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
          <%=p.getName() %>   
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <%=p.getPhone() %>   
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label for="sitename">性 别：</label>
        </div>
        <div class="field">
          <%=p.getSex() %>   
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">联系地址：</label>
        </div>
        <div class="field">
          <%=p.getAddress() %>   
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>