$(function(){
	$("#bt_login").click(function(){
		if($("#username").val()=="")
		{
		$("#nullname").show();
		}else if($("#password").val()=="")
			{
			$("#nullpassword").show();
			}
		else{
			$.post("login.htm?method=login",
					{username:$("#username").val(),password:$("#password").val()},
					function(data,status){
						if (status=="success"&&data!="errorpassword"&&data!="erroruser") {
							window.location.href="/WEB-INF/admin/manage.jsp";
						}
						else if(data=="errorpassword")
						{
							$("#error_password").show();
						}else $("#error_user").show();
					});
		}
});
	});
	
	