<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'manage.jsp' starting page</title>
    
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
    <div class="row">
         <div class="col-md-8 text-primary" style="margin-left:500px;"><h1 style="margin-top:30px;font-size: 53px;">网上在线<strong>投票</strong>管理系统</h1></div>
      </div>
      <div style="margin-top:50px;">
   <table class="table table-striped table-bordered table-hover" style="width:700px;" align="center">
     <tr>
       <th>投票id</th><th>投票标识</th><th>投票名称</th><th>投票类型</th><th>图形类型</th><th>操作类型</th>
       <c:forEach items="${votes }" var="v">
          <tr><td>${v.id}</td><td>${v.name}</td><td>${v.title}</td><td>${v.votetype }</td><td>${v.pictype }</td>
          <td><a href="operate.htm?method=delete&id=${v.id}" >删除投票</a>&nbsp;<a href="operate.htm?method=update&id=${v.id }">修改投票</a>&nbsp;<a href="display.htm?method=play&id=${v.id }">查看结果</a></td></tr>
       </c:forEach>
     </tr>
   
   </table>
   </div>
   
   <button type="button" class="btn btn-warning" style="margin-left:500px;" >新建投票对象</button>
    <div class="modal" id="mymodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h2 class="modal-title">添加投票</h2>
			</div>
			<div class="modal-body">
				<form action="operate.htm?method=add" method="post" class="form-horizontal" role="form">
				 
                  <div class="form-group">
  				    <label class="col-sm-3 control-label">投票名称：</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" name="add_name" >
                    </div>
                 </div>
  
                  <div class="form-group">
  				    <label class="col-sm-3 control-label">投票标题：</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" name="add_title" >
                    </div>
                 </div>
				
                  <div class="form-group">
  				    <label class="col-sm-3 control-label">投票类型：</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" name="add_votetype" >
                    </div>
                 </div>
                 
                  <div class="form-group">
  				    <label class="col-sm-3 control-label">图形类型：</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" name="add_pictype" >
                    </div>
                 </div>
                 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                 <input type="submit" class="btn btn-primary">
				</form>
			</div>	
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript" src="js/jquery.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-transition.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-modal.js"></script>
<script>
  $(function(){
    $(".btn").click(function(){
      $("#mymodal").modal("toggle");
    });
  });
</script>


  </body>
</html>
