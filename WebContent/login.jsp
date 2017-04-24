<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  type="text/css" href="<c:url value='/css/bootstrap.min.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/user.css'/>"/>
</head>
<body>
		<div  class="container">
				<h2 id="header" >淘宝账户登录</h2>
			<div id="nav" >
				<form action="<c:url value='/LoginServlet'/>" method="post" onsubmit="return checkedAll();">
				<div id="username"><label>账户</label>
					<input id="a1" type="text" value="" name="user_name" placeholder="手机号/邮箱/会员名"/>
					<span id="usernametip"></span>
				</div>
				
				<div id="password"><label>登录密码</label>
					<input id="p1" type="password" value="" name="user_password" placeholder="请输入密码" />
					<span id="passwordtip"></span>
				</div>
				<div id="message"><c:out value="${message}"></c:out></div>
				<div id="login"><input id="l1" type="submit" value="登录" />
				</div>
				
				</form>

				<a href="<c:url value='/register.jsp'/>">免费注册</a>
			</div>			
		</div>
	</body>
	<script type="text/javascript" src="<c:url value='/js/jquery-1.12.3.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/login.js'/>"></script>
</html>
