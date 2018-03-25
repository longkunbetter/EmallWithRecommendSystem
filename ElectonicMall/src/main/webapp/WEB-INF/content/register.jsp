<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册一个帐号</title>
	<link rel="Shortcut Icon" type="images/x-icon" href="images/favicon.ico">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/jquery.min.js"></script>
	<!--theme-style-->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--fonts-->
	<!-- start menu -->
	<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/memenu.js"></script>
	<script>$(document).ready(function(){$(".memenu").memenu();});</script>
	<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<%@include file="heade.jsp"%>

<!--content-->
<div class=" container">
	<div class=" register">
		<h1>注册帐号</h1>
		<form>
			<div class="col-md-6 register-top-grid">
				<h3>个人信息</h3>
				<div>
					<span>年龄</span>
					<input type="text" name="age">
				</div>
				<div>
					<span>性别</span>
					<input type="text" name="gender">
				</div>
				<div>
					<span>所在地</span>
					<input type="text" name="address">
				</div>
				<a class="news-letter" href="#">
					<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>同意使用协议</label>
				</a>
			</div>
			<div class="col-md-6 register-bottom-grid">
				<h3>登录信息</h3>
				<div>
					<span>登录名</span>
					<input type="text" name="username">
				</div>
				<div>
					<span>密码</span>
					<input type="password" name="password">
				</div>
				<div>
					<span>确认密码</span>
					<input type="password" name="confirmpwd">
				</div>
				<input type="submit" value="注册">

			</div>
			<div class="clearfix"> </div>
		</form>
	</div>
	</div>
</div>

<!--foot-->
<%@include file="foot.jsp"%>
</body>
</html>
