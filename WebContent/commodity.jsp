<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情页</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/xiangqingye.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/app.js" type="text/javascript"></script>
</head>
<body>
	<div id="container">
		<div id="heading">
			<div id="lunbo">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="img/lunbo/lb1.jpg" alt="">
						</div>
						<div class="item">
							<img src="img/lunbo/1b2.jpg" alt="">
						</div>
						<div class="item">
							<img src="img/lunbo/lb3.jpg" alt="">
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"
							aria-hidden="true"></span>
						</a>
					</div>
				</div>
			</div>
			<div id="jiesao">
				<div id="sp_name">
					<p>
						<strong>${commodity.commodity_name}</strong>
					</p>
				</div>
				<div id="sp_pay">
					<p>&yen;${commodity.commodity_price}</p>
				</div>
				<div class="row" id="sp_kd">
					<div class="col-xs-4">
						<p>快递&nbsp;0.00</p>
					</div>
					<div class="col-xs-4">
						<p>月销量&nbsp;0件</p>
					</div>
					<div class="col-xs-4">
						<p>${commodity.store.store_address}</p>
					</div>
				</div>
			</div>
		</div>
		<div id="bodying">
			<div class="row" id="row1">
				<div class="col-xs-3">
					<img src="img/shangpin/gou.png" />
					<p>正品保证</p>
				</div>
				<div class="col-xs-3">
					<img src="img/shangpin/gou.png" />
					<p>赠运费险</p>
				</div>
				<div class="col-xs-3">
					<img src="img/shangpin/gou.png" />
					<p>极速退款</p>
				</div>
				<div class="col-xs-3">
					<img src="img/shangpin/gou.png" />
					<p>七天退换</p>
				</div>
			</div>
			<div id="bd_container">
				<div id="Logo">
					<img src="${commodity.store.store_src}" /> <span>${commodity.store.store_name}</span>
				</div>
				<div id="message" class="row">
					<div class="col-xs-4 text-center">
						<p>描述相符4.8</p>
					</div>
					<div class="col-xs-4 text-center">
						<p>服务态度4.8</p>
					</div>
					<div class="col-xs-4 text-center">
						<p>发货速度4.8</p>
					</div>
				</div>
				<div id="btn" class="overflow">
					<div class="btn1">
						<img src="img/menu2.jpg" /><span><a href="#">全部商品</a></span>
					</div>
					<div class="btn1">
						<img src="img/menu1.png" /><span><a href="#">进入店铺</a></span>
					</div>
				</div>
			</div>
			<div id="other">
				<p>看了又看</p>
				<div class="col-xs-4">
					<div class="centent">
						<img src="img/shangpin/other_1.jpg" />
					</div>
					<div class="centent">
						<a>德国双立人ZWLLING&nbsp;多用刀&nbsp;限量珍藏版</a>
					</div>
					<p>&yen;10888.00</p>
				</div>
				<div class="col-xs-4">
					<div class="centent">
						<img src="img/shangpin/other_2.jpg" />
					</div>
					<div class="centent">
						<a>德国双立人Profection&nbsp;刀具6件套&nbsp;限量珍藏版</a>
					</div>
					<p>&yen;7288.00</p>
				</div>
				<div class="col-xs-4">
					<div class="centent">
						<img src="img/shangpin/other_3.jpg" />
					</div>
					<div class="centent">
						<a>德国双立人Aitura&nbsp;镀银西餐具&nbsp;限量珍藏版</a>
					</div>
					<p>&yen;18888.00</p>
				</div>
			</div>
		</div>
		<div id="footer">
			<img src="img/footer.png" class="footer_1" />
			<div class="row">
				<div class="col-xs-3">
					<a href="#">登录</a>
				</div>
				<div class="col-xs-3">
					<a href="#">注册</a>
				</div>
				<div class="col-xs-3">
					<a href="#">天猫首页</a>
				</div>
				<div class="col-xs-3">下载客户端</div>
			</div>
			<p>&copy;某宝版权所有</p>
		</div>

		<div id="float">
			<c:url value='/AddShopCarServlet' var="shopcar">
				<c:param name="commodity_id" value="${commodity.commodity_id}" />
				<c:param name="commodity_price" value="${commodity.commodity_price}" />
			</c:url>
			<div class="float1">
				<a href="shoppingcart.html"><img
					src="img/shoppingcart/shoppingcart.png" /></a>
			</div>
			<div class="float2">评论</div>
			<a href="${shopcar}"><div class="float3">加入购物车</div></a>
			<div class="float4">立即购买</div>
		</div>
	</div>
</body>
</html>
