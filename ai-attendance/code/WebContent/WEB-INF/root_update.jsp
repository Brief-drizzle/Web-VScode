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
<%
	int flag = 0;
	try{
		flag = Integer.parseInt(request.getParameter("flag"));
	}catch(Exception e){}
	if(flag == 1){
%>
			<script>
                alert("管理员信息修改成功！");
            </script>
<%} %>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>管理员信息修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="root_update">
      <div class="form-group">
        <div class="label">
          <label for="sitename">账号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="name" size="50" placeholder="请输入账号" data-validate="required:请输入账号" />       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="password" size="50" placeholder="请输入密码" data-validate="required:请输入密码" />       
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提 交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>