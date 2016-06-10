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
    
    <title>My JSP 'toVote.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <script type="text/javascript" src="js/jquery.js">    
     </script>
     <script type="text/javascript">
     $(function(){
    	 $("#submit").click(function(){
    		 $.post("joinVote.htm?method=count",{item:$("input:radio:checked").val()},function(data,status){
    			 if(data=='true'){
    				 //弹出投票成功
    				 alert("投票成功!");
    				 //跳转到task
    				 setTimeout(function(){
    					 window.location.href="joinVote.htm?method=show";
    				 },2000);
    				 
    			 }
    			 else if( data=='false')
    				 {
    				 //弹出投票失败
    				 alert("您已经投过票了!");
    				 }
    			 else{
    				 alert("投票失败，请稍后重试!");
    			 }
    		 })
    	 });
     });
     </script>
  </head>
  
  <body> 
   <c:if test="${sessionScope.user==null}">
  <c:redirect url="index.jsp"></c:redirect>
</c:if> 
  <form action="joinVote.htm?method=count" method="post"  align="center" style="font-size:30px; margin-top:100px;">
    <div class="form-group">
        ${title}   
    
    <table  align="center" style="font-size:20px;">
    <c:forEach items="${itemList}" var="i" > 
    <div class="radio">
     <tr style="height:45px;">
       <td> <input type="radio" value="${i.id }" name="item" id="item"></td>
       <td>${i.title}</td>
        </tr>
        </div>
    </c:forEach>
    </table>
    <input type="button" id="submit" class="btn btn-primary" value="提交">
    </div>
    </form>
  </body>
</html>
