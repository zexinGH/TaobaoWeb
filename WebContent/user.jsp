<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/mytaobao.css" />
		<script type="text/javascript" src="js/mui.min.js"></script>
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript">
			mui.init({
			    keyEventBind: {
			        backbutton: true  //打开back按键监听
			    }
			});
			$(document).ready(function(){
			  $(".xiala").click(function(){
			    $(".xiugai"). fadeToggle();
			  });
			});
		</script>
	</head>
	<body>
		<div id="container">
			<div id="xiangqing" class="row">
				<div class="col-xs-2">
					<a class="btn btn-default" href="<c:url value='/index.jsp'/>" role="button">返回</a>
				</div>
				<div class="col-xs-offset-3 col-xs-3">
					<span class="label">用户详情</span>
				</div>
				<div class="col-xs-offset-2 col-xs-2">
					<a class="btn btn2 btn-default" href="" role="button">· · ·</a>
				</div>

			</div>
			<div id="header">
				<div id="touxiang"  class="row">
					<div class="col-xs-5">
						<img src="img/xiangqing/touxiang.jpg"/>
						<span style="font-size:20px">${user.user_name}</span>
					</div>					
					<div class="col-xs-7">
						<a href="<c:url value='/shopcar.jsp'/>">
							<li class="gouwuche">
								<span id=""><em>0</em></span><br>
								<span id="">我的购物车</span>
							</li>
						</a>
						<a href="">
							<li class="shoucang">
								<span id=""><em>0</em></span><br>
								<span id="">我的收藏</span>
							</li>
						</a>
						<a href="">
							<li class="liulanjilu">
								<span id=""><em>0</em></span><br>
								<span id="">浏览记录</span>
							</li>
						</a>
					</div>
				</div>								
			</div>
			
			<div id="order">
				<span id="">&nbsp;我的订单</span>
				<a href="<c:url value=''/>"><span id="all">全部订单＞</span></a><hr/>
				<div class="row">
					<div class="col-xs-4">
						<a href="">
							<li>
								<span id=""><img src="img/xiangqing/daifukuan.png"/></span><br>
								<span id="">待付款</span>
							</li>
						</a>
					</div>
					
					<div class="col-xs-4">
						<a href="">
							<li>
								<span id=""><img src="img/xiangqing/daifahuo.png"/></span><br>
								<span id="">待发货</span>
							</li>
						</a>
					</div>
					<div class="col-xs-4">
						<a href="">
							<li>
								<span id=""><img src="img/xiangqing/xiuhuan.png"/></span><br>
								<span id="">返修/退换</span>
							</li>
						</a>
					</div>
				</div>				
			</div>
			<div id="zhgl">
				<div class="xiala">
					<span id="">&nbsp;账户管理&nbsp;</span>
					<span class="glyphicon glyphicon glyphicon-chevron-down" aria-hidden="true"></span>		
				</div>
				<div class="xiugai">
					<h4>请输入你要修改的信息</h4>
					<form action="<c:url value='/UpdateUserServlet'/>" method="post">
					  <div class="form-group">
					  	<input type="hidden" name="user_id" value="${user.user_id}">
					    <label for="InputName">&nbsp;输入用户名</label>
					    <input type="text" class="form-control" id="user_name" name="user_name" placeholder="" value="${user.user_name}">
					  </div>
					  <div class="form-group">
					    <label for="InputPassword">&nbsp;输入新密码</label>
					    <input type="password" class="form-control" id="user_password" name="user_password" placeholder="" value="${user.user_password}">
					  </div>
					  <div class="form-group">
					    <label for="InputAddress">&nbsp;更改送货地址</label>
					    <input type="text" class="form-control" name="user_address" id="InputAddress" placeholder="" value="${user.user_address}">
					  </div>
					  <div>
					  </div>
					  <button type="submit" class="btn btn-danger">提交</button>
					</form>
				</div>
			</div>
		</div>
		
	</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</html>
