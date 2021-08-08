<%--
   Document   : index
   Created on : 2020-5-10, 9:49:31
   Author     : Administrator
--%>
<!-- https://blog.csdn.net/qq_43620805/article/details/107969267 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
   <title>欢迎使用</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="css/pintuer.css">
   <script src="js/jquery.js"></script>
   <script src="js/pintuer.js"></script>
</head>
<body>
<!--头部开始-->
<%--        <%@include file="WEB-INF/jspf/header.jspf" %>--%>
<!--头部结束-->

<!--内容开始-->
<div class="container padding-big-top padding-big-bottom">
   <div class="line-big">
       <div class="xl12 xs3 xm3 xb7">
           <form method="post" action="/faceinsert" enctype="multipart/form-data">
               <div class="form-group">
                   <div class="label">
                       <label for="yno">
                           用户编号</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="sno" name="yno" size="50" placeholder="用户编号" value="${yonghu.yno}" data-validate="required:必填" />
                   </div>
               </div>
               <div class="form-group">
                   <div class="label">
                       <label for="username">
                           用户名</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="snmae" name="username" size="50" placeholder="用户名" value="${yonghu.username}" data-validate="required:必填"/>
                   </div>
               </div>
               <div class="form-group">
                   <div class="label">
                       <label for="userloginname">
                           用户登录名</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="ssex" name="userloginname" size="50" placeholder="用户登录名"  value="${yonghu.userloginname}"/>
                   </div>
               </div>
               <div class="form-group">
                   <div class="label">
                       <label for="password">
                           密码</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="ssex" name="password" size="50" placeholder="密码"  value="${yonghu.userloginname}"/>
                   </div>
               </div>
               <div class="form-group">
                   <div class="label">
                       <label for="apassword">
                           确认密码</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="ssex" name="apassword" size="50" placeholder="确认密码"  value="${yonghu.userloginname}"/>
                   </div>
               </div>
               <div class="form-group">
                   <div class="label">
                       <label for="name">
                           姓名</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="sage" name="name" size="50" placeholder="姓名"  value="${yonghu.name}" data-validate="required:必填"/>
                   </div>
               </div>
               <div class="form-group">
                   <div class="label">
                       <label for="sex">
                           性别</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="sdept" name="sex" size="50" placeholder="性别" value="${yonghu.sex}" data-validate="required:必填"/>
                   </div>
               </div>


               <div class="form-group">
                   <div class="label">
                       <label for="username">
                           电话</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="phone" name="tel" size="50" placeholder="电话"  value="${yonghu.tel}" data-validate="required:必填"/>
                   </div>
               </div>
               <div class="form-group">
                   <div class="label">
                       <label for="username">
                           邮箱</label>
                   </div>
                   <div class="field">
                       <input type="text" class="input" id="phone" name="email" size="50" placeholder="电话"  value="${yonghu.email}" data-validate="required:必填"/>
                   </div>
               </div>

<%--                <div>  <!--验证码-->--%>
<%--                    <input  type="text" name="checkCode"/>--%>

<%--                    <img alt="验证码" id="imagecode" src="/ImageServlet"/>--%>
<%--                    <a href="javascript:void(0)" οnclick="myReload()">看不清楚</a><br>--%>


<%--                    <script type="text/javascript">--%>
<%--                        function myReload()--%>
<%--                        {--%>

<%--                            document.getElementById("imagecode").src ="/ImageServlet?"+Math.random();--%>
<%--                        }--%>
<%--                    </script>--%>
<%--                </div>--%>

               <p style="color: red">${err}</p>

               <div>
                   <input placeholder="请选择头像" type="file" name="image"/>
               </div>
               <div class="form-button">
                   <button class="button" type="submit">
                       提交</button>

               </div>

           </form>
       </div>
       <div class="xl12 xs9 xm9 xb5 padding-small-top">
           <img src="images/1.jpg" alt="学生信息管理系统" width="500px" height="350px"/>
       </div>
   </div>
</div>
<!--内容结束-->

<!--尾部开始-->
<%--        <%@include file="WEB-INF/jspf/footer.jspf" %>--%>
<!--尾部结束-->
</body>
</html>