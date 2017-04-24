<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>淘宝首页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script type="text/javascript" src="js/mui.min.js"></script>
		<script type="text/javascript">
			mui.init({
			    keyEventBind: {
			        backbutton: true  //打开back按键监听
			    }
			});
			mui.back = function () {
			    var btn = ["确定", "取消"];
			    mui.confirm('退出淘宝商城？', '提示', btn, function (e) {
			        if (e.index == 0) {
			            plus.runtime.quit();//退出APP
			        }
			    });
			}
		</script>
	</head>
	<body>
		<div class="container">

			<div id="header">
				<a href="#" class="logo"><img src="img/tao.jpg" /></a>
				<a href="gallery.jsp" class="search">
					<input type="text" class="form-control" id="input_box" placeholder="寻找宝贝店铺" />
				</a>
					<c:choose>
						<c:when test="${empty user}"><a href="login.jsp" class="login">登录</a></c:when>
						<c:when test="${not empty user}"><a href="<c:url value='/user.jsp'/>" class="login">用户</a></c:when>
					</c:choose>
						
						
<!--				<a href="login.html" class="login">登录</a>-->
			</div>
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					<li data-target="#carousel-example-generic" data-slide-to="4"></li>
					<li data-target="#carousel-example-generic" data-slide-to="5"></li>
				</ol>

				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="img/lunbo/TB13NelJFXXXXc2aXXXSutbFXXX.jpg_q50.jpg" alt="">
						<div class="carousel-caption">
						</div>
					</div>

					<div class="item">
						<img  src="img/lunbo/TB1_NCAKXXXXXbNXVXXdIns_XXX-1125-352.jpg_q50.jpg" alt="">
						<div class="carousel-caption">

						</div>
					</div>
					<div class="item">
						<img src="img/lunbo/TB12fRSKXXXXXb1XXXXXXXXXXXX-1125-352.jpg_q50.jpg" alt="">
						<div class="carousel-caption">

						</div>
					</div>
					<div class="item">
						<img src="img/lunbo/TB14LpxKXXXXXblXFXXSutbFXXX.jpg_q50.jpg" alt="">
						<div class="carousel-caption">

						</div>
					</div>
					<div class="item">
						<img src="img/lunbo/TB1Jp8EMFXXXXb5XFXXSutbFXXX.jpg_q50.jpg" alt="">
						<div class="carousel-caption">

						</div>
					</div>
					<div class="item">
						<img src="img/lunbo/TB1oqXJKXXXXXaYaXXXXXXXXXXX-1125-352.jpg_q50.jpg" alt="">
						<div class="carousel-caption">

						</div>
					</div>

				</div>

				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>

			</div>
			<div class="category row">
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/tianmao.png"/>
					<br/><span>天猫</span></a>
					
				</div>
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/juhuasuan.png"/>
					<br/><span>聚划算</span></a>
					
				</div>
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/daojia.png"/>
					<br/><span>到家</span></a>
					
				</div>
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/waimai.png"/>
					<br/><span>外卖</span></a>
					
				</div>
				
			</div>
			<div class="category row">
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/chongzhi.png"/>
					<br/><span>充值</span></a>
					
				</div>
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/allx.png"/><br/><span>阿里旅行</span></a>
					
				</div>
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/lingjinbi.png"/>
					<br/><span>领金币</span></a>
					
				</div>
				<div class="col-xs-3">
					<a href="gallery.html"><img src="img/module one/fenlei.png"/>
					<br/><span>分类</span></a>
					
				</div>
			</div>
			<div id="hpz">
				<img src="img/haopinzhi.png" />
			</div>
			<div class="hpztp row">
				<div class="fir col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/fcdp.jpg" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/qqjp.png" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/czlb.png" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/jmp.jpg" /></a>
				</div>
			</div>
			<div class="hpztp row">
				<div class="fir col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/tttj.png" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/ppdq.png" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/lrg.png" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module two/tqc.png" /></a>
				</div>
			</div>
			<div id="rmsc">
				<img src="img/remenshichang.png" />
			</div>
			<div class="rmsctp row">
				<div class="col-xs-6">
					<a href="dianpushouye.html"><img src="img/module three/qqss.png" /></a>
				</div>
				<div class="col-xs-6">
					<a href="dianpushouye.html"><img src="img/module three/ppj.png" /></a>
				</div>
			</div>
			<div class="rmsctp row">
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module three/ttgj.png" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module three/snyg.jpg" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module three/shj.jpg" /></a>
				</div>
				<div class="col-xs-3">
					<a href="dianpushouye.html"><img src="img/module three/mxs.jpg" /></a>
				</div>
			</div>
			<div id="footer">
				<c:if test="${empty user}">
					<a href="login.jsp"><button type="button" class="btn btn-info">登录</button></a>

					<a href="register.jsp"><button type="button" class="btn btn-info">注册</button></a>
				</c:if>
				<a href=""><button type="button" class="btn btn-info">电脑版</button></a>

				<a href=""><button type="button" class="btn btn-info">用户反馈</button></a>

			</div>
		</div>
		<script type="text/javascript" src="js/jquery.min.js"></script>
	    <script type="text/javascript" src="js/bootstrap.min.js"></script>
	</body>
</html>