<%@page import="entity.Register"%>
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
<jsp:useBean id="Jdbc2" class="jdbc.VisitorJdbc" scope="page"></jsp:useBean>
<jsp:useBean id="Jdbc3" class="jdbc.Worker1Jdbc" scope="page"></jsp:useBean>
<jsp:useBean id="Jdbc4" class="jdbc.Worker2Jdbc" scope="page"></jsp:useBean>
<%
	ServletContext context = request.getServletContext();
	Register r = new Register(); 
	String info1,info2,info3,info4,info5;
	
	
	int flag = 0;
	try{
		flag = Integer.parseInt(request.getParameter("flag"));
	}catch(Exception e){}
	r = (Register)context.getAttribute("user");
	
	if(r.getS1() == null){
		flag = 2;
	}

%>
			

<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>识别结果</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="root_update">
    
    	<%if(flag == 1){ 
    	 %>
      <div class="form-group">
        <div class="field">
          <label for="sitename"><h2 style="margin-left:30px;"><%=r.getS1() %></h2></label>
        </div>   
      </div>
      <div class="form-group">
        <div class="field">
          <label for="sitename"><h2 style="margin-left:30px;"><%=r.getS2() %></h2></label>
        </div>   
      </div>
      <div class="form-group">
        <div class="field">
          <label for="sitename"><h2 style="margin-left:30px;"><%=r.getS3() %></h2></label>
        </div>   
      </div>
      <div class="form-group">
        <div class="field">
          <label for="sitename"><h2 style="margin-left:30px;"><%=r.getS4() %></h2></label>
        </div>   
      </div>
      <div class="form-group">
        <div class="field">
          <label for="sitename"><h2 style="margin-left:30px;"><%=r.getDate() %></h2></label>
        </div>   
      </div>

      <%}if(flag == 2){ %>
      <div class="form-group">
        <div class="label">
          <label for="sitename"><h1 style="color:red">陌生人！</h1></label>
        </div>
      </div> 
      <%} %>
    </form>
  </div>
</div>
</body></html>