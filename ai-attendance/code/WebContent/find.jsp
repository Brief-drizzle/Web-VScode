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

<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>出入信息查找</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="find">
      <div class="form-group">
        <div class="label">
          <label for="sitename">查找人姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="name" size="50" placeholder="请输入查找人姓名" data-validate="required:请输入查找人姓名" />       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">身份选择：</label>
        </div>
        <div class="field">
           <label><input name="identity" type="radio" value="1" />本地住户 </label> 
		   <label><input name="identity" type="radio" value="2" />访客</label>
		   <label><input name="identity" type="radio" value="3" />外卖员 </label> 
		   <label><input name="identity" type="radio" value="4" />快递员</label>
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