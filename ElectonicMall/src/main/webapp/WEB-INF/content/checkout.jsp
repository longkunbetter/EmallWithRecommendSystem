<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>我的购物车_推一推商城</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- start menu -->
	<link href="${pageContext.request.contextPath}/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/memenu.js"></script>
	<script>$(document).ready(function(){$(".memenu").memenu();});</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</head>
<body>
<!--header-->
<%@include file="heade.jsp"%>
<div class="container">
	<div class="check">
		<h1>我的购物车 (${commodityData.amount})</h1>
		<div class="col-md-9 cart-items">
			<c:forEach items="${commodityData.items}" var="item" varStatus="status">
				<div id="${item.commodity.id}_div" class="cart-header">
					<div class="close1" href="javascript:voie(0)" onclick="removeCommodityFromCart(${item.commodity.id})"> </div>
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<img src="/commodity/img/${item.commodity.mainimg}" class="img-responsive" alt=""/>
						</div>
						<div class="cart-item-info">
							<h3>
								<a href="/commodity/details/${item.commodity.id}">${item.commodity.title}</a>
								<span>商品编号: ${item.commodity.id}</span>
							</h3>
							<ul class="qty">
								<li><p>数量 : ${item.amount}</p></li>
								<li><p>金额 : ${item.amount * item.commodity.price}</p></li>
							</ul>

							<div class="delivery">
								<p>单价 : ${item.commodity.price}</p>
								<span>库存充足</span>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="col-md-3 cart-total">
			<a class="continue" href="${pageContext.request.contextPath}/index">再买几件</a>
			<div class="price-details">
				<h3>总额明细</h3>
				<span>总额</span>
				<span class="total1">${commodityData.price}</span>
				<span>商品数量</span>
				<span class="total1">${commodityData.amount}</span>
				<span>折扣</span>
				<span class="total1">0.00</span>
				<div class="clearfix"></div>
			</div>
			<ul class="total_price">
				<li class="last_price"> <h4>实际金额</h4></li>
				<li class="last_price"><span>${commodityData.price}</span></li>
				<div class="clearfix"> </div>
			</ul>

			<div class="clearfix"></div>
			<a class="order" href="#">结算订单</a>
			<div class="total-item">
				<h3>&nbsp;</h3>
				<h4>&nbsp;</h4>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<%@include file="foot.jsp"%>
</body>
</html>
