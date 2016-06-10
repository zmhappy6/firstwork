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
    
    <title>My JSP 'task.jsp' starting page</title>
    
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
  
  <body>
  <!-- <h1 style="margin-left:500px;">${message}</h1>-->
   <c:if test="${sessionScope.user==null}">
  <c:redirect url="index.jsp"></c:redirect>
</c:if> 
  
    <div class="row">
         <div class="col-md-8 text-primary" style="margin-left:600px;"><h1 style="margin-top:30px;font-size: 53px;">网上在线<strong>投票</strong></h1></div>
      </div>
      <div style="margin-top:50px;">
   <table class="table table-striped table-bordered table-hover" style="width:700px;" align="center">
     <tr>
       <th>投票标识</th><th>投票名称</th><th>去投票</th>
       <c:forEach items="${votes }" var="v">
          <tr><td>${v.name}</td><td>${v.title}</td>
          <td><a href="joinVote.htm?method=toVote&id=${v.id}" >去投票</a></td>
     </tr>
   </c:forEach>
   </table>
   </div>
  </body>
</html>
