<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/shopcarCss.css" rel="stylesheet" type="text/css" />
<%--<script src="js/jquery.min.js"></script>
--%>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/app.js"></script>
</head>
<body>
	<div id="centent">
		<div id="heading" class="overflow">
			<div id="back">
				<a href="shanpingye.html">&lt;</a>
			</div>
			<div id="title">
				<p>购物车</p>
			</div>
		</div>
		<div id="bodying1">
			<div id="bd_centent">
				<div id="img">
					<img src="img/shoppingcart/shoppingcart.png" />
				</div>
				<div class="text t1">
					<p>购物车快饿瘪了T.T</p>
				</div>
				<div class="text t2">
					<p>主人快给我挑点宝贝吧</p>
				</div>
				<div>
					<button class="btn btn-default" type="submit">去逛逛</button>
				</div>
			</div>

		</div>

		<div id="bodying2">
			<div id="bd_centent2">
				<ul id="shopcar">
					<li id="shopcar_top">
						<span>&nbsp;&nbsp;双立人官方旗舰店&nbsp;&gt;</span>
						<span id='editShop' value='edit'>编辑</span>
					</li>
					<form action="<c:url value='/AddOrderServlet'/>" method="get">
						<c:forEach items="${myItems}" var="item">
							<li class="shopcar overflow">
								<div class="box">
									<input type="checkbox" name="order_item_id" class="mybox"
										value="${item.order_item_id}">
								</div>
								<div class="img">
									<img src="img/dj_19888.jpg" />
								</div>
								<div class="commshow">
									<div class="name">
										<span>${item.commodity.commodity_name}</span>
									</div>
									<div class="buydesc">颜色：红色 型号：120</div>
									<div class="pay">
										<span>&yen;</span> <span>${item.order_item_subtotal}</span> <span
											class="goodscount">x${item.order_item_count}</span>
									</div>
								</div>

								<div class="editshow">
									<button class="delbtn" type="submit"
										style="float: right;width: 100px;height: 86px;">删除</button>
									<div class="buyCount">
										<p class="p_num">
											<span class="sy_minus">-</span> <input class="sy_num"
												readonly="readonly" type="text" name="" value="1" /> 
											<span class="sy_plus">+</span>
										</p>
									</div>
									<div class="buydesc">颜色：红色 型号：120</div>
								</div></li>
						</c:forEach>
						<li class="shopcar_bottom">
							<div class="allcheck">
								<input id="allCheckBox" type="checkbox" value="" /><span>全选</span>
							</div>
							<div class="settlenment">
								<input class="btn btn-default" type="submit" value="结算"></input>
							</div>
							<div class="total">
								合计：&yen;<span>0.00</span>
							</div>
						</li>
					</form>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
