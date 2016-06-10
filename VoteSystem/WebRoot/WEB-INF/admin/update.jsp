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
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
    <form action="operate.htm?method=save&id=${id }" method="post" name="form">
            投票标识：<input type="text" value=${name} name="name"><br>
            投票名称：<input type="text" value=${title} name="title"><br>
            投票类型：<input type="text" value=${votetype} name="votetype"><br>
            图形类型：<input type="text" value=${pictype } name="pictype"><br>
   <input type="submit" class=" btn btn-primary" id="vote_update_btn"  value="保存" style="width:80px;height:29px;margin-top:15px;margin-left:65px;">
    </form>
    </div>
    </div>
    <h3  align="center" style="margin-top:30px;">已存在的投票选项</h3>
    <button type="button" class="btn btn-warning" id="add_voteItem" style="margin-left:900px; margin-top:-40px; margin-bottom:20px;" >添加选项</button>
    <div class="modal" id="mymodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h2 class="modal-title">添加投票</h2>
			</div>
			<div class="modal-body">
				<form action="voteitem.htm?method=add&vote_id=${id}" method="post" class="form-horizontal" role="form">
				 
                  <div class="form-group">
  				    <label class="col-sm-3 control-label">选项：</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" name="add_title" id="add_title" >
                    <input type="hidden" class="form-control" value="${id}" id="vote_id" >
                    </div>
                 </div>
  
                  <div class="form-group">
  				    <label class="col-sm-3 control-label">票数：</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" name="add_votenum" id="add_votenum" >
                   
                    </div>
                 </div>
				   
                  
                 
                <div class="form-group">
                  <div align="center">
                 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                 <input type="button"  class="btn btn-primary" id="add_btn" value="保存" >
                 
                 </div>
                 </div>
				</form>
			</div>	
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
      
       <table class="table table-striped table-bordered table-hover" style="width:700px;" align="center">
          <tr>
            <th>选项</th><th>票数</th><th>操作</th>
          </tr>
          <c:forEach items="${voteItemList }" var="v">
           <tr>
            <td>${v.title}</td><td>${v.votenum}</td><td><a style="cursor:pointer" link="voteitem.htm?method=delete&id=${v.id }" id="delete" class="delete">删除选项</a>&nbsp;&nbsp;<a href="voteitem.htm?method=update&id=${v.id }">修改选项</a></td>
          </tr>
          </c:forEach>
       </table>

    <script src="js/jquery.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-transition.js"></script>
   <script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-modal.js"></script>
   <script>
  $(function(){
    $("#add_voteItem").click(function(){
      $("#mymodal").modal("toggle");
    });
   $("#add_btn").click(function(){
	   $.post("voteitem.htm?method=add&vote_id="+$("#vote_id").val(),{add_title:$("#add_title").val(),add_votenum:$("#add_votenum").val()},function(data,status){
		   if(data=="true"){
			   $("#mymodal").modal("toggle");
			   alert("添加成功！");
			   
			  window.location.reload();
		   }else{
			   $("#mymodal").modal("toggle");
			   alert("添加失败！");
		   }
	   });
   });
   $(".delete").click(function(){
	   if(confirm("是否删除")){
		   $.post($(this).attr("link"),function(data,status){
			   if(status=="success")
				   {
				   window.location.reload();
				   }
		   });
	   }
   });
  });
  
  </script>
  </body>
</html>
