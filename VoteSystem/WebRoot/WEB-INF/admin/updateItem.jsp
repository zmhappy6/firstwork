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
    
    <title>My JSP 'updateItem.jsp' starting page</title>
    
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
   <c:if test="${sessionScope.user==null}">
  <c:redirect url="index.jsp"></c:redirect>
</c:if> 
  <h1 align="center" style="margin-bottom:30px;">投票信息</h1>
  <a href="operate.htm?method=show" style="margin-left: 1300px; class="btn btn-primary">返回首页</a>
    <div align="center" style="font-size: 20px; border:solid 1px; width:400px; margin-left:550px;">
    <div style="padding-top:30px;padding-bottom:15px;">
    <form action="voteitem.htm?method=save&id=${id }" method="post" name="form">
           
            选项：<input type="text" value=${title} name="title"><br>
             数量：<input type="text" value=${votenum} name="votenum"><br>
          <input type="hidden" value=${vote_id} name="vote_id"><br>
           <input type="hidden" value=${id} name="id"><br>
              <input type="submit" class=" btn btn-primary" id="vote_update_btn"  value="保存" style="width:80px;height:29px;margin-top:15px;margin-left:65px;">
             </form>
             </div>
             </div>
  </body>
</html>
