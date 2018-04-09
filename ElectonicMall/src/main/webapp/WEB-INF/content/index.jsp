<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>推一推商城-首页</title>
	<link rel="Shortcut Icon" type="images/x-icon" href="images/favicon.ico">

	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/jquery.min.js"></script>

	<!-- Custom Theme files -->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="electonic mall" />
	<script type="application/x-javascript">
        addEventListener("load",function() {setTimeout(hideURLbar, 0);},false);
        function hideURLbar(){window.scrollTo(0,1);}
	</script>

	<!-- start menu -->
	<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/memenu.js"></script>
	<script>$(document).ready(function(){$(".memenu").memenu();});</script>
	<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<%@include file="heade.jsp" %>

<!--banner-->
<div class="banner">
	<div class="container">
		<script src="js/responsiveslides.min.js"></script>
		<script>
            $(function () {
                $("#slider").responsiveSlides({
                    auto: true,
                    nav: true,
                    speed: 500,
                    namespace: "callbacks",
                    pager: true
                });
            });
		</script>
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">
				<c:forEach items="${requestScope.commodityData.pannelData}" var="item" varStatus="status">
					<li>
						<div class="banner-text">
							<h3>${item.title}</h3>
							<p>${item.desc}</p>
							<a href="/commodity/details/${item.id}">了解更多</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>

<!--content-->
<div class="content">
	<div class="container">
		<!--为你推荐-->
		<div class="content-top">
			<h1>为你推荐</h1>
			<div class="grid-in">
				<c:forEach items="${requestScope.commodityData.guessData}" var="item" varStatus="status">
					<c:if test="${status.index < 3}">
						<div class="col-md-4 grid-top">
							<a href="/commodity/details/${item.id}" class="b-link-stripe b-animate-go  thickbox">
								<img class="img-responsive" src="/commodity/img/${item.mainimg}" alt="">
								<div class="b-wrapper">
									<h3 class="b-animate b-from-left    b-delay03 ">
										<span>${item.title}</span>
									</h3>
								</div>
							</a>
							<p><a href="/commodity/details/${item.id}">${item.title}</a></p>
						</div>
					</c:if>
				</c:forEach>
				<div class="clearfix"> </div>
			</div>
			<div class="grid-in">
				<c:forEach items="${requestScope.commodityData.guessData}" var="item" varStatus="status">
					<c:if test="${status.index >= 3}">
						<div class="col-md-4 grid-top">
							<a href="/commodity/details/${item.id}" class="b-link-stripe b-animate-go  thickbox">
								<img class="img-responsive" src="/commodity/img/${item.mainimg}" alt="">
								<div class="b-wrapper">
									<h3 class="b-animate b-from-left    b-delay03 ">
										<span>${item.title}</span>
									</h3>
								</div>
							</a>
							<p><a href="/commodity/details/${item.id}">${item.title}</a></p>
						</div>
					</c:if>
				</c:forEach>
				<div class="clearfix"> </div>
			</div>
		</div>

		<!--特色商品-->
		<div class="content-top-bottom">
			<h2>特色商品</h2>
			<div class="col-md-6 men">
				<a href="/commodity/details/${requestScope.commodityData.featureData[0].id}" class="b-link-stripe b-animate-go  thickbox">
					<img class="img-responsive" src="/commodity/img/${requestScope.commodityData.featureData[0].mainimg}" alt="" style="height:560px">
					<div class="b-wrapper">
						<h3 class="b-animate b-from-top top-in   b-delay03 ">
							<span>${requestScope.commodityData.featureData[0].title}</span>
						</h3>
					</div>
				</a>
			</div>
			<div class="col-md-6">
				<div class="col-md1 ">
					<a href="/commodity/details/${requestScope.commodityData.featureData[1].id}" class="b-link-stripe b-animate-go  thickbox" style="height:270px">
						<img class="img-responsive" src="/commodity/img/${requestScope.commodityData.featureData[1].mainimg}" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-top top-in1   b-delay03 ">
								<span>${requestScope.commodityData.featureData[1].title}</span>
							</h3>
						</div>
					</a>
				</div>
				<div class="col-md2">
					<div class="col-md-6 men1">
						<a href="/commodity/details/${requestScope.commodityData.featureData[2].id}" class="b-link-stripe b-animate-go  thickbox">
							<img class="img-responsive" src="/commodity/img/${requestScope.commodityData.featureData[2].mainimg}" alt="">
							<div class="b-wrapper">
								<h3 class="b-animate b-from-top top-in2   b-delay03 ">
									<span>${requestScope.commodityData.featureData[2].title}</span>
								</h3>
							</div>
						</a>
					</div>
					<div class="col-md-6 men2">
						<a href="/commodity/details/${requestScope.commodityData.featureData[3].id}" class="b-link-stripe b-animate-go  thickbox">
							<img class="img-responsive" src="/commodity/img/${requestScope.commodityData.featureData[3].mainimg}g" alt="">
							<div class="b-wrapper">
								<h3 class="b-animate b-from-top top-in2   b-delay03 ">
									<span>${requestScope.commodityData.featureData[3].title}</span>
								</h3>
							</div>
						</a>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!---->
	<div class="content-bottom">
		<ul>
			<li><a href="#"><img class="img-responsive" src="images/lo.png" alt=""></a></li>
			<li><a href="#"><img class="img-responsive" src="images/lo1.png" alt=""></a></li>
			<li><a href="#"><img class="img-responsive" src="images/lo2.png" alt=""></a></li>
			<li><a href="#"><img class="img-responsive" src="images/lo3.png" alt=""></a></li>
			<li><a href="#"><img class="img-responsive" src="images/lo4.png" alt=""></a></li>
			<li><a href="#"><img class="img-responsive" src="images/lo5.png" alt=""></a></li>
			<div class="clearfix"> </div>
		</ul>
	</div>
</div>
<%@include file="foot.jsp"%>
</body>
</html>
