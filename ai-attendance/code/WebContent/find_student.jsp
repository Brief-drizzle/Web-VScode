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
		ServletContext context = request.getServletContext();
		int identity = 0,pid = 0;
    	try{
    		pid = (Integer)context.getAttribute("pid");
    		System.out.println("pid="+pid);
    	}catch(Exception e){}
    %>
    	
<body>
<form method="post" action="" id="listform">
  	<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">学生签到信息管理·查询</strong></div>
    <table class="table table-hover text-center">
      <tr>
        <th>姓 名</th>
        <th>学 号</th>
        <th>联系电话</th>
        <th>身  份</th>
        <th>签到时间</th> 
      </tr>     
       <volist name="list" id="vo">
        <%
        	int i= 0;
        	List<Register> list = Jdbc.findAll();
            for(Register r : list){   
            
            	System.out.println(r.getStatus() + "}}" +r.getPid() + "}}" + pid);
            	if(r.getPid()==pid && r.getStatus() == 1){i++;
            	if(r.getStatus() == 1){
            		r.setS1(Jdbc2.findByid(r.getPid()).getName());
            		r.setS2(Jdbc2.findByid(r.getPid()).getPhone());
            		r.setS4(Jdbc2.findByid(r.getPid()).getNumber2());
            		r.setS3("学 生");
            	}if(r.getStatus() == 2){
            		r.setS1(Jdbc3.findByid(r.getPid()).getName());
            		r.setS2(Jdbc3.findByid(r.getPid()).getPhone());
            		r.setS3("");
            	}if(r.getStatus() == 3){
            		r.setS1(Jdbc4.findByid(r.getPid()).getName());
            		r.setS2(Jdbc4.findByid(r.getPid()).getPhone());
            		r.setS3("");
            	}if(r.getStatus() == 4){
            		r.setS1(Jdbc5.findByid(r.getPid()).getName());
            		r.setS2(Jdbc5.findByid(r.getPid()).getPhone());
            		r.setS3("");
            	}
        %>
        <tr>  
          <td><%=r.getS1() %></td>
          <td><%=r.getS4() %></td>
          <td><%=r.getS2() %></td>
          <td><%=r.getS3() %></td>
          <td><%=r.getDate() %></td>      
        </tr>
         <%}} %>

      
    </table>
    &nbsp;&nbsp;&nbsp;&nbsp;<h2>共<%=i %>条签到信息</h2>
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