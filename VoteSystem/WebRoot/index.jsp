<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	 
  </head>
  
  <body style="border:solid #eee 55px;">
    
    <div  style="background-image: url(picture/2.jpg);background-repeat:no-repeat;background-size:1517px 570px; margin-bottom:-15px;height:563px;">
      <div class="row">
         <div class="col-md-8 text-primary" style="margin-left:130px;"><h1 style="margin-top:130px;font-size: 53px;">网上在线<strong>投票</strong>管理系统</h1></div>
      </div>
    <form class="form-horizontal"  action="login.htm?method=login" method="post" style="margin-top:80px;">
  <div class="form-group has-feedback" style="margin-bottom:20px;">
    <label for="username" class="col-sm-2 control-label"  style="font-size:15px;">用户名:</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="username" name="username" value="${cookie.username.value}">
      
      <span class="help-block" id="error_user">${message2}</span>
    </div>  
    </div>
    <div class="form-group ">    
    </div>
    <div class="form-group">
     <label for="password" class="col-sm-2 control-label" style="font-size:15px;">密码:</label>
     <div class="col-sm-3">
     <input type="password" id="password" name="password" value="${cookie.password.value}"  class="form-control"> 
     <span class="help-block" id="error_password" >${message1}</span>
     </div>
  </div>
        <div class="form-group" >
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox" style="font-size:17px;">
        <label>
          <input type="checkbox" name="check" value="select" ${cookie.username.value!=null?'checked':''} style="width:22px;height:22px;" >&nbsp;记住密码
        </label>
      </div>
    </div>
  </div>
    <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" id="bt_login" class="btn btn-primary" style="margin-left:30px;width:90px;">登录</button>
      <button type="reset" class="btn btn-primary" style="margin-left:20px;width:90px;">重置</button>
    </div>
  </div>
  </form>
    </div>
    <script src="js/jquery-1.9.0.min.js"></script>
  </body>
</html>
