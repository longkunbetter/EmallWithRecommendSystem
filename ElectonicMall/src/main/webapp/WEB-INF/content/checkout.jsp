<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Checkout</title>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.min.js"></script>
	<!-- Custom Theme files -->
	<!--theme-style-->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--fonts-->
	<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
	<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
	<!-- start menu -->
	<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/memenu.js"></script>
	<script>$(document).ready(function(){$(".memenu").memenu();});</script>
	<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<%@include file="heade.jsp"%>

<div class="container">
	<div class="check">
		<h1>My Shopping Bag (2)</h1>
		<div class="col-md-9 cart-items">

			<script>$(document).ready(function(c) {
                $('.close1').on('click', function(c){
                    $('.cart-header').fadeOut('slow', function(c){
                        $('.cart-header').remove();
                    });
                });
            });
			</script>
			<div class="cart-header">
				<div class="close1"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						<img src="images/pic1.jpg" class="img-responsive" alt=""/>
					</div>
					<div class="cart-item-info">
						<h3><a href="#">Mountain Hopper(XS R034)</a><span>Model No: 3578</span></h3>
						<ul class="qty">
							<li><p>Size : 5</p></li>
							<li><p>Qty : 1</p></li>
						</ul>

						<div class="delivery">
							<p>Service Charges : Rs.100.00</p>
							<span>Delivered in 2-3 bussiness days</span>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="clearfix"></div>

				</div>
			</div>
			<script>$(document).ready(function(c) {
                $('.close2').on('click', function(c){
                    $('.cart-header2').fadeOut('slow', function(c){
                        $('.cart-header2').remove();
                    });
                });
            });
			</script>
			<div class="cart-header2">
				<div class="close2"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						<img src="images/pic2.jpg" class="img-responsive" alt=""/>
					</div>
					<div class="cart-item-info">
						<h3><a href="#">Mountain Hopper(XS R034)</a><span>Model No: 3578</span></h3>
						<ul class="qty">
							<li><p>Size : 5</p></li>
							<li><p>Qty : 1</p></li>
						</ul>
						<div class="delivery">
							<p>Service Charges : Rs.100.00</p>
							<span>Delivered in 2-3 bussiness days</span>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="clearfix"></div>

				</div>
			</div>
		</div>
		<div class="col-md-3 cart-total">
			<a class="continue" href="#">Continue to basket</a>
			<div class="price-details">
				<h3>Price Details</h3>
				<span>Total</span>
				<span class="total1">6200.00</span>
				<span>Discount</span>
				<span class="total1">---</span>
				<span>Delivery Charges</span>
				<span class="total1">150.00</span>
				<div class="clearfix"></div>
			</div>
			<ul class="total_price">
				<li class="last_price"> <h4>TOTAL</h4></li>
				<li class="last_price"><span>6350.00</span></li>
				<div class="clearfix"> </div>
			</ul>


			<div class="clearfix"></div>
			<a class="order" href="#">Place Order</a>
			<div class="total-item">
				<h3>OPTIONS</h3>
				<h4>COUPONS</h4>
				<a class="cpns" href="#">Apply Coupons</a>
				<p><a href="#">Log In</a> to use accounts - linked coupons</p>
			</div>
		</div>

		<div class="clearfix"> </div>
	</div>
</div>
<%@include file="foot.jsp"%>
</body>
</html>
