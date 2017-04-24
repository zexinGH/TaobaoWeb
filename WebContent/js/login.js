			function checkedUserName(){
				var UserName = $("#a1").val();
				$("#usernametip").html("");
				if(UserName.length == 0){
					$("#usernametip").html("<a1>用户名不能为空!</a1>");
					$("#a1").focus();
					return false;
				}
				if(UserName.length<6){
					$("#usernametip").html("<a1>用户名长度至少6位！</a1>");
					$("#a1").focus();
					return false;
				}
				if(UserName.length>16){
					$("#usernametip").html("<a1>用户名长度至多16位！</a1>");
					$("#a1").focus();
					return false;
				}
				return true;
			}
			
			function checkedPassword(){
				var Password=$("#p1").val();
				$("#passwordtip").html("");
				if(Password.length==0){
					$("#passwordtip").html("<a1>密码不能为空!</a1>");
					return false;
				}
				if(Password.length<6){
					$("#passwordtip").html("<a1>密码长度至少6位！</a1>");
					$("#p1").focus();
					return false;
				}
				if(Password.length>16){
					$("#passwordtip").html("<a1>密码长度至多16位！</a1>");
					$("#p1").focus();
					return false;
				}
				return true;
			}
			
			function checkedAll(){
				if(checkedUserName()&&checkedPassword()){
					return true;
				}else{
					return false;
				}
			}
			
			$(function(){
				$("#a1").blur(checkedUserName);
				$("#p1").blur(checkedPassword);
				$("#form[method='post']").submit(function(){
					return checkedAll();
				});
			});