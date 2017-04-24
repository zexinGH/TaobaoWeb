<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>淘宝列表</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/mui.min.js"></script>
<script type="text/javascript">
	mui.init({
		keyEventBind : {
			backbutton : true
		//打开back按键监听
		}
	});

	window.onload = function() {
		var search = document.getElementById("search");
		search.oninput = function() {
			var keyword = search.value;
			ajax({
				method : "POST",
				params : "keyword=" + keyword,
				url : "<c:url value='/CommodityAjaxServlet'/>",
				type : "json",
				callback : function(data) {
					var commodityList = data;
					if (commodityList != null) {
						$("#result").html("");
						var str;
						for (var i = 0; i < commodityList.length; i++) {
							str+= "<div class='item clearfix'>"//
									+ "<div class='img fl'><a href='<c:url value='/CommodityServlet?commodity_id="+commodityList[i].commodity_id+"'/>'>"//
									+ "<img src='img/u5.jpg' /></a></div><div class='info fl'><h3>"//
									+ commodityList[i].commodity_name//
									+ "</h3><div class='price'><span>"//
									+ commodityList[i].commodity_price//
									+ "</span></div><ul class='clearfix'><li>免运费</li><li>219人付款</li><li>"//
									+ commodityList[i].store.store_address//
									+ "</li></ul></div></div>"
						}
						$("#result").html(str);
					}
				}
			});
		}
	}
</script>
</head>

<body>
	<div class="wrap">
		<div class="head">
			<div class="search clearfix">
				<div class="baobei fl" id="xial">
					宝贝<img src="img/u1.png" />
				</div>
				<div class="in fl">
					<input type="text" placeholder="长袖T恤" name="pname" id="search" />
				</div>
			</div>
			<a href="index.jsp" class="shouy"><img src="img/u2.png" /></a>

			<div class="tanc" id="tanc" style="display: none;">
				<img class="img" src="img/u8.png" />
				<ul class="clearfix">
					<li><img src="img/u9.png" /><span>宝贝</span></li>
					<li><img src="img/u9.png" /><span>店铺</span></li>
				</ul>
			</div>
		</div>
		<div class="bar">
			<div class="paih">
				<ul class="clearfix">
					<li class="first">综合排序<img src="img/u4.png" /></li>
					<span></span>
					<li>销量优先</li>
					<span></span>
					<li>筛选</li>
				</ul>
			</div>
			<a href="#" class="qh"><img src="img/u3.png" /></a>
		</div>
		<div id="result">
			<div class="item clearfix">
				<div class="img fl">
					<a href="#"><img src="img/u5.jpg" /></a>
				</div>
				<div class="info fl">
					<h3>骆驼男装t恤商务休闲polo衫条纹保罗衫</h3>
					<div class="price">
						<span>￥168</span><em>￥336</em>
					</div>
					<ul class="clearfix">
						<li>免运费</li>
						<li>219人付款</li>
						<li>广州</li>
					</ul>
				</div>
			</div>
			<div class="item clearfix">
				<div class="img fl">
					<a href=""><img src="img/u6.jpg" /></a>
				</div>
				<div class="info fl">
					<h3>骆驼男装t恤商务休闲polo衫条纹保罗衫</h3>
					<div class="price">
						<span>￥168</span><em>￥336</em>
					</div>
					<ul class="clearfix">
						<li>免运费</li>
						<li>219人付款</li>
						<li>广州</li>
					</ul>
				</div>
			</div>
			<div class="item clearfix">
				<div class="img fl">
					<a href=""><img src="img/u7.jpg" /></a>
				</div>
				<div class="info fl">
					<h3>骆驼男装t恤商务休闲polo衫条纹保罗衫</h3>
					<div class="price">
						<span>￥168</span><em>￥336</em>
					</div>
					<ul class="clearfix">
						<li>免运费</li>
						<li>219人付款</li>
						<li>广州</li>
					</ul>
				</div>
			</div>
			<div class="item clearfix">
				<div class="img fl">
					<a href=""><img src="img/u5.jpg" /></a>
				</div>
				<div class="info fl">
					<h3>骆驼男装t恤商务休闲polo衫条纹保罗衫</h3>
					<div class="price">
						<span>￥168</span><em>￥336</em>
					</div>
					<ul class="clearfix">
						<li>免运费</li>
						<li>219人付款</li>
						<li>广州</li>
					</ul>
				</div>
			</div>
			<div class="item clearfix">
				<div class="img fl">
					<a href=""><img src="img/u5.jpg" /></a>
				</div>
				<div class="info fl">
					<h3>骆驼男装t恤商务休闲polo衫条纹保罗衫</h3>
					<div class="price">
						<span>￥168</span><em>￥336</em>
					</div>
					<ul class="clearfix">
						<li>免运费</li>
						<li>219人付款</li>
						<li>广州</li>
					</ul>
				</div>
			</div>
			<div class="item clearfix">
				<div class="img fl">
					<a href=""><img src="img/u5.jpg" /></a>
				</div>
				<div class="info fl">
					<h3>骆驼男装t恤商务休闲polo衫条纹保罗衫</h3>
					<div class="price">
						<span>￥168</span><em>￥336</em>
					</div>
					<ul class="clearfix">
						<li>免运费</li>
						<li>219人付款</li>
						<li>广州</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="page">
			<span>上一页</span> <select class="select">
				<option>第一页</option>
				<option>第二页</option>
				<option>第三页</option>
			</select> <span>下一页</span>
		</div>
	</div>
	<script type="text/javascript">
		document.getElementById("xial").onclick = function() {
			var a = document.getElementById("tanc");
			if (a.style.display == "none") {
				a.style.display = "block";
			} else {
				a.style.display = "none";
			}
		}
	</script>
	<script type="text/javascript"
		src="<c:url value='/ajaxutils/ajaxutils.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/js/jquery-1.12.3.min.js'/>"></script>
</body>
</html>