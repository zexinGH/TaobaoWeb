<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/user.css'/>" />
<script type="text/javascript">
	
<%-- 刷新验证码--%>
	function change() {
		var date = new Date();
		var vcode = document.getElementById("vcode");
		vcode.src = "/taobaoweb/VerifyCodeServlet?" + date.getTime();
	}

	window.onload = function() {
		var a1 = document.getElementById("a1");
		a1.onblur = function() {
			var username = a1.value;
			var state = checkedUserName();
			if (state) {
				ajax({
					method : "POST",
					params : "user_name=" + username,
					url : "<c:url value='/UsernameAjaxServlet'/>",
					type : "text",
					callback : function(data) {
						$("#usernametip").html(data);
					}
				});
			}
		}
		var n1 = document.getElementById("n1");
		n1.onblur = function() {
			var verify_code = n1.value;
			var state = checkedVerifyCode();
			if (state) {
				ajax({
					method : "POST",
					params : "verify_code=" + verify_code,
					url : "<c:url value='/VerifyCodeServlet'/>",
					type : "text",
					callback : function(data) {
						$("#vcodetip").html(data);
					}
				});
			}
		}
	}
</script>
</head>
<body>
	<div class="container">
		<a href="login.jsp"><input id="back" type="submit" value="返回" /></a>
		<h2 id="header">淘宝注册界面</h2>
		<div id="nav">
			<form action="<c:url value='/RegisterServlet'/>" method="post"
				onsubmit="return checkedAll();">
				<div id="username">
					<label>账户</label> <input id="a1" type="text" value=""
						name="user_name" placeholder="手机号/邮箱/会员名" /> <span
						id="usernametip"></span>
				</div>

				<div id="password">
					<label>密码</label> <input id="p1" type="password" value=""
						name="user_password" placeholder="请输入密码" /> <span
						id="passwordtip"></span>
				</div>

				<div id="address">
					<label>地址</label> <input id="d1" type="address" value=""
						name="user_address" placeholder="请输入住址" />

				</div>

				<div id="sex">
					<label>性别</label> <select id="s1" name="user_gender">
						<option>----点击此处选择性别----</option>
						<option>男</option>
						<option>女</option>
					</select>
				</div>
				<div id="pin">
					<label>验证码</label> 
					<input id="n1" type="text" value="" name="verify_code" /> 
					<img id="vcode" src="<c:url value='/VerifyCodeServlet' />" border="1" /> 
					<a style="float: none;text-decoration:underline; color: blue;font-size:17px" 
					href="javascript:change()" id="refresh">看不清</a><span id="vcodetip"></span>
				</div>
				<div id="message"><c:out value="${requestScope.message}"></c:out></div>
				<div id="login">
					<input id="l1" type="submit" value="注册" />
				</div>
			</form>

		</div>
	</div>
</body>
<script type="text/javascript"
	src="<c:url value='/js/jquery-1.12.3.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/register.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/ajaxutils/ajaxutils.js'/>"></script>
</html>