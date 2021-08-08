<%@page import="entity.Register"%>
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
<jsp:useBean id="Jdbc" class="jdbc.RegisterJdbc" scope="page"></jsp:useBean>
<jsp:useBean id="Jdbc2" class="jdbc.PeopleJdbc" scope="page"></jsp:useBean>
<jsp:useBean id="Jdbc3" class="jdbc.VisitorJdbc" scope="page"></jsp:useBean>
<jsp:useBean id="Jdbc4" class="jdbc.Worker1Jdbc" scope="page"></jsp:useBean>
<jsp:useBean id="Jdbc5" class="jdbc.Worker2Jdbc" scope="page"></jsp:useBean>
	<% 
		int flag = 0;
    	try{
    		flag = Integer.parseInt(request.getParameter("flag"));
    	}catch(Exception e){}
    	if(flag == 1){
    %>
    		<script>
                alert("信息添加成功！");
            </script>
    <%}if(flag == 2){ %>
   			 <script>
                alert("信息删除成功");
            </script>
     <%} %>
<body>
<form method="post" action="" id="listform">
  	<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">小区出入信息管理</strong></div>
    <table class="table table-hover text-center">
      <tr>
        <th>姓 名</th>
        <th>联系电话</th>
        <th>身  份</th>
        <th>出入时间</th>
        <th>操 作</th>
      </tr>     
       <volist name="list" id="vo">
        <%
        	List<Register> list = Jdbc.findAll();
            for(Register r : list){            
            	if(r.getStatus() == 1){
            		r.setS1(Jdbc2.findByid(r.getPid()).getName());
            		r.setS2(Jdbc2.findByid(r.getPid()).getPhone());
            		r.setS3("本地小区人员");
            	}if(r.getStatus() == 2){
            		r.setS1(Jdbc3.findByid(r.getPid()).getName());
            		r.setS2(Jdbc3.findByid(r.getPid()).getPhone());
            		r.setS3("来访人员");
            	}if(r.getStatus() == 3){
            		r.setS1(Jdbc4.findByid(r.getPid()).getName());
            		r.setS2(Jdbc4.findByid(r.getPid()).getPhone());
            		r.setS3("外卖员");
            	}if(r.getStatus() == 4){
            		r.setS1(Jdbc5.findByid(r.getPid()).getName());
            		r.setS2(Jdbc5.findByid(r.getPid()).getPhone());
            		r.setS3("快递员");
            	}
        %>
        <tr>  
          <td><%=r.getS1() %></td>
          <td><%=r.getS2() %></td>
          <td><%=r.getS3() %></td>
          <td><%=r.getDate() %></td>
          <td><div class="button-group"> <a class="button border-main" href="register_delete?id=<%=r.getId() %>" style="padding: 4px 8px;">信息删除</a> 
        </tr>
         <%} %>

      
    </table>
    &nbsp;&nbsp;&nbsp;&nbsp;<h2>共<%=list.size() %>条信息</h2>
  </div>
</form>
<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}
</script>
</body>
</html>