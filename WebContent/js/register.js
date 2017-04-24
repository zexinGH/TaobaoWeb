function checkedUserName(){
	var UserName = $("#a1").val();
	$("#usernametip").html("");
	if(UserName.length == 0){
		$("#usernametip").html("<a1>用户名不能为空!</a1>");
		return false;
	}
	if(UserName.length<6){
		$("#usernametip").html("<a1>用户名长度至少6位！</a1>");
		return false;
	}
	if(UserName.length>16){
		$("#usernametip").html("<a1>用户名长度至多16位！</a1>");
		return false;
	}
	return true;
}

function checkedPassword(){
	var Password=$("#p1").val();
	$("#passwordtip").html("");
	if(Password.length==0){
		$("#passwordtip").html("<a1>密码不能为空!</a1>");
//		$("#p1").focus();
		return false;
	}
	if(Password.length<6){
		$("#passwordtip").html("<a1>密码长度至少6位！</a1>");
//		$("#p1").focus();
		return false;
	}
	if(Password.length>16){
		$("#passwordtip").html("<a1>密码长度至多16位！</a1>");
//		$("#p1").focus();
		return false;
	}
	return true;
}
function checkedVerifyCode(){
	var vcode = $("#n1").val();
	$("#vcodetip").html("");
	if(vcode.length==0||vcode.length!=4){
		$("#vcodetip").html("<a1>请输入4位验证码</a1>");
		return false;
	}
	if(vcode.length>4){
		$("#vcodetip").html("<a1>验证码长度不超过4</a1>");
//		$("#n1").focus();
		return false;
	}
	return true;
}

function checkedAll(){
	if(checkedUserName()&&checkedPassword()&&checkedVerifyCode()){
		return true;
	}else{
		return false;
	}
}

$(function(){
	$("#a1").blur(checkedUserName);
	$("#p1").blur(checkedPassword);
	$("#n1").blur(checkedVerifyCode);
	$("#form[method='post']").submit(function(){
		return checkedAll();
	});
});