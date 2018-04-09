<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录帐号-推一推</title>
	<link rel="Shortcut Icon" type="images/x-icon" href="images/favicon.ico">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/jquery.min.js"></script>
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
<div class="container">
	<div class="account">
		<h1>账户登录</h1>
		<div class="account-pass">
			<div class="col-md-8 account-top">
				<form action="/common/user/login" method="post">
					<div>
						<span>用户名</span>
						<input type="text" name="username">
					</div>
					<div>
						<span >密码</span>
						<input type="password" name="password">
					</div>
					<input type="submit" value="登录">
				</form>
			</div>
			<div class="col-md-4 left-account ">
				<a href="single.jsp"><img class="img-responsive " src="images/s1.jpg" alt=""></a>
				<div class="five">
					<h2>25% </h2><span>discount</span>
				</div>
				<a href="register.jsp" class="create">Create an account</a>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>

</div>

<!--//foot-->
<%@include file="foot.jsp"%>
</body>
</html>
