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
                alert("信息上传成功！");
            </script>
<%} %>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>访客信息上传</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="visitor_add"  enctype="multipart/form-data">
      <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="name" size="50" placeholder="请输入姓名" data-validate="required:请输入姓名" />       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">性 别：</label>
        </div>
        <div class="field">
          	<label><input name="sex" type="radio" value="男" />男 </label> 
			<label><input name="sex" type="radio" value="女" />女 </label>  
        </div>
      </div> 
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">到访地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="address" size="50" placeholder="请输入到访地址" data-validate="required:请输入到访地址" />       
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="phone" size="50" placeholder="请输入联系方式" data-validate="required:请输入联系方式" />       
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label for="sitename">上传照片：</label>
        </div>
        <div class="field">
         	<input type="file" id="doc-vld-pwd-1" required name="image">          
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