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
				<li>
					<div class="banner-text">
						<h3>Lorem Ipsum is not simply dummy  </h3>
						<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor .</p>
						<a href="single.html">Learn More</a>
					</div>
				</li>
				<li>
					<div class="banner-text">
						<h3>There are many variations </h3>
						<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor .</p>
						<a href="single.html">Learn More</a>
					</div>
				</li>
				<li>
					<div class="banner-text">
						<h3>Sed ut perspiciatis unde omnis</h3>
						<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor .</p>
						<a href="single.html">Learn More</a>
					</div>
				</li>
			</ul>
		</div>

	</div>
</div>

<!--content-->
<div class="content">
	<div class="container">
		<div class="content-top">
			<h1>NEW RELEASED</h1>
			<div class="grid-in">
				<div class="col-md-4 grid-top">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/pi.jpg" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>T-Shirt</span>
							</h3>
						</div>
					</a>


					<p><a href="single.html">Contrary to popular</a></p>
				</div>
				<div class="col-md-4 grid-top">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/pi1.jpg" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>Shoe</span>
							</h3>
						</div>
					</a>
					<p><a href="single.html">classical Latin</a></p>
				</div>
				<div class="col-md-4 grid-top">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/pi2.jpg" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>Bag</span>
							</h3>
						</div>
					</a>
					<p><a href="single.html">undoubtable</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="grid-in">
				<div class="col-md-4 grid-top">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/pi3.jpg" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>Shirt</span>
							</h3>
						</div>
					</a>
					<p><a href="single.html">suffered alteration</a></p>
				</div>
				<div class="col-md-4 grid-top">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/pi4.jpg" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>Bag</span>
							</h3>
						</div>
					</a>
					<p><a href="single.html">Content here</a></p>
				</div>
				<div class="col-md-4 grid-top">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/pi5.jpg" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>Shoe</span>
							</h3>
						</div>
					</a>
					<p><a href="single.html">readable content</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<!----->

		<div class="content-top-bottom">
			<h2>Featured Collections</h2>
			<div class="col-md-6 men">
				<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t1.jpg" alt="">
					<div class="b-wrapper">
						<h3 class="b-animate b-from-top top-in   b-delay03 ">
							<span>Lorem</span>
						</h3>
					</div>
				</a>


			</div>
			<div class="col-md-6">
				<div class="col-md1 ">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t2.jpg" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-top top-in1   b-delay03 ">
								<span>Lorem</span>
							</h3>
						</div>
					</a>

				</div>
				<div class="col-md2">
					<div class="col-md-6 men1">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t3.jpg" alt="">
							<div class="b-wrapper">
								<h3 class="b-animate b-from-top top-in2   b-delay03 ">
									<span>Lorem</span>
								</h3>
							</div>
						</a>

					</div>
					<div class="col-md-6 men2">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t4.jpg" alt="">
							<div class="b-wrapper">
								<h3 class="b-animate b-from-top top-in2   b-delay03 ">
									<span>Lorem</span>
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
