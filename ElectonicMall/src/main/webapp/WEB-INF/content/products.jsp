<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>${requestScope.commodityData.categorizeName}_推一推商城</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- Custom Theme files -->
	<!--theme-style-->
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- start menu -->
	<link href="${pageContext.request.contextPath}/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/memenu.js"></script>
	<script>$(document).ready(function(){$(".memenu").memenu();});</script>
	<script src="${pageContext.request.contextPath}/js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<%@include file="heade.jsp"%>

<!--content-->
<!---->
<div class="product">
	<div class="container">
		<div class="col-md-3 product-price">

			<div class=" rsidebar span_1_of_left">
				<div class="of-left">
					<h3 class="cate">Categories</h3>
				</div>
				<ul class="menu">
					<li class="item1"><a href="#">Men </a>
						<ul class="cute">
							<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
							<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
							<li class="subitem3"><a href="single.jsp">Automatic Fails </a></li>
						</ul>
					</li>
					<li class="item2"><a href="#">Women </a>
						<ul class="cute">
							<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
							<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
							<li class="subitem3"><a href="single.jsp">Automatic Fails </a></li>
						</ul>
					</li>
					<li class="item3"><a href="#">Kids</a>
						<ul class="cute">
							<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
							<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
							<li class="subitem3"><a href="single.jsp">Automatic Fails</a></li>
						</ul>
					</li>
					<li class="item4"><a href="#">Accesories</a>
						<ul class="cute">
							<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
							<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
							<li class="subitem3"><a href="single.jsp">Automatic Fails</a></li>
						</ul>
					</li>

					<li class="item4"><a href="#">Shoes</a>
						<ul class="cute">
							<li class="subitem1"><a href="product.html">Cute Kittens </a></li>
							<li class="subitem2"><a href="product.html">Strange Stuff </a></li>
							<li class="subitem3"><a href="product.html">Automatic Fails </a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--initiate accordion-->
			<script type="text/javascript">
                $(function() {
                    var menu_ul = $('.menu > li > ul'),
                        menu_a  = $('.menu > li > a');
                    menu_ul.hide();
                    menu_a.click(function(e) {
                        e.preventDefault();
                        if(!$(this).hasClass('active')) {
                            menu_a.removeClass('active');
                            menu_ul.filter(':visible').slideUp('normal');
                            $(this).addClass('active').next().stop(true,true).slideDown('normal');
                        } else {
                            $(this).removeClass('active');
                            $(this).next().stop(true,true).slideUp('normal');
                        }
                    });

                });
			</script>
			<!---->
			<div class="product-middle">

				<div class="fit-top">
					<h6 class="shop-top">Lorem Ipsum</h6>
					<a href="single.jsp" class="shop-now">SHOP NOW</a>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="sellers">
				<div class="of-left-in">
					<h3 class="tag">Tags</h3>
				</div>
				<div class="tags">
					<ul>
						<li><a href="#">design</a></li>
						<li><a href="#">fashion</a></li>
						<li><a href="#">lorem</a></li>
						<li><a href="#">dress</a></li>
						<li><a href="#">fashion</a></li>
						<li><a href="#">dress</a></li>
						<li><a href="#">design</a></li>
						<li><a href="#">dress</a></li>
						<li><a href="#">design</a></li>
						<li><a href="#">fashion</a></li>
						<li><a href="#">lorem</a></li>
						<li><a href="#">dress</a></li>

						<div class="clearfix"> </div>
					</ul>

				</div>

			</div>
			<!---->
			<div class="product-bottom">
				<div class="of-left-in">
					<h3 class="best">Best Sellers</h3>
				</div>
				<div class="product-go">
					<div class=" fashion-grid">
						<a href="single.jsp"><img class="img-responsive " src="${pageContext.request.contextPath}/images/p1.jpg" alt=""></a>

					</div>
					<div class=" fashion-grid1">
						<h6 class="best2"><a href="single.jsp" >Lorem ipsum dolor sit
							amet consectetuer  </a></h6>

						<span class=" price-in1"> $40.00</span>
					</div>

					<div class="clearfix"> </div>
				</div>
				<div class="product-go">
					<div class=" fashion-grid">
						<a href="single.jsp"><img class="img-responsive " src="${pageContext.request.contextPath}/images/p2.jpg" alt=""></a>

					</div>
					<div class="fashion-grid1">
						<h6 class="best2"><a href="single.jsp" >Lorem ipsum dolor sit
							amet consectetuer </a></h6>

						<span class=" price-in1"> $40.00</span>
					</div>

					<div class="clearfix"> </div>
				</div>

			</div>
			<div class=" per1">
				<a href="single.jsp" ><img class="img-responsive" src="${pageContext.request.contextPath}/images/pro.jpg" alt="">
					<div class="six1">
						<h4>DISCOUNT</h4>
						<p>Up to</p>
						<span>60%</span>
					</div></a>
			</div>
		</div>
		<!--9宫格商品-->
		<!--第一行-->
		<div class="col-md-9 product1">
			<div class=" bottom-product">
				<c:forEach items="${requestScope.commodityData.data}" var="item" varStatus="status">
					<c:if test="${status.index < 3}">
						<div class="col-md-4 bottom-cd simpleCart_shelfItem">
							<div class="product-at ">
								<a href="/commodity/details/${item.id}">
									<img class="img-responsive" src="/commodity/img/${item.mainimg}" alt="">
									<div class="pro-grid">
										<span class="buy-in">剁手吧!</span>
									</div>
								</a>
							</div>
							<p class="tun">${item.title}</p>
							<a href="#" class="item_add">
								<p class="number item_price"><i> </i>${item.price} 元</p>
							</a>
						</div>
					</c:if>
				</c:forEach>
				<div class="clearfix"> </div>
			</div>
			<!--第二行-->
			<div class=" bottom-product">
				<c:forEach items="${requestScope.commodityData.data}" var="item" varStatus="status">
					<c:if test="${3<=status.index && status.index < 6}">
						<div class="col-md-4 bottom-cd simpleCart_shelfItem">
							<div class="product-at ">
								<a href="/commodity/details/${item.id}">
									<img class="img-responsive" src="/commodity/img/${item.mainimg}" alt="">
									<div class="pro-grid">
										<span class="buy-in">剁手吧!</span>
									</div>
								</a>
							</div>
							<p class="tun">${item.title}</p>
							<a href="#" class="item_add">
								<p class="number item_price"><i> </i>${item.price} 元</p>
							</a>
						</div>
					</c:if>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
			<!--第三行-->
			<div class=" bottom-product">
				<c:forEach items="${requestScope.commodityData.data}" var="item" varStatus="status">
					<c:if test="${6<=status.index && status.index < 9}">
						<div class="col-md-4 bottom-cd simpleCart_shelfItem">
							<div class="product-at ">
								<a href="/commodity/details/${item.id}">
									<img class="img-responsive" src="/commodity/img/${item.mainimg}" alt="">
									<div class="pro-grid">
										<span class="buy-in">剁手吧!</span>
									</div>
								</a>
							</div>
							<p class="tun">${item.title}</p>
							<a href="#" class="item_add">
								<p class="number item_price"><i> </i>${item.price} 元</p>
							</a>
						</div>
					</c:if>
				</c:forEach>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="clearfix"> </div>

		<nav class="in">
			<ul class="pagination">
				<!--如果是第一页，上一页不可用-->
				<c:choose>
					<c:when test="${requestScope.commodityData.nowPage == 1}">
						<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="${pageContext.request.contextPath}/commodity/categorize?categorizeId=${requestScope.commodityData.categorizeId}&nowPage=${requestScope.commodityData.nowPage - 1}" aria-label="Previous">
								<span aria-hidden="true">«</span>
							</a>
						</li>
					</c:otherwise>
				</c:choose>
				<!--页码-->
				<c:forEach begin="1" end="${requestScope.commodityData.pageCount}" var="i">
					<c:choose>
						<c:when test="${i == requestScope.commodityData.nowPage}">
							<li class="active"><a href="#">${i}<span class="sr-only">(current)</span></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/commodity/categorize?categorizeId=${requestScope.commodityData.categorizeId}&nowPage=${i}">${i}<span class="sr-only"></span></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!--如果是最后一页，下一页不可用-->
				<c:choose>
					<c:when test="${requestScope.commodityData.nowPage == requestScope.commodityData.pageCount}">
						<li class="disabled"> <a href="#" aria-label="Next"><span aria-hidden="true">»</span> </a> </li>
					</c:when>
					<c:otherwise>
						<li> <a href="${pageContext.request.contextPath}/commodity/categorize?categorizeId=${requestScope.commodityData.categorizeId}&nowPage=${requestScope.commodityData.nowPage + 1}" aria-label="Next"><span aria-hidden="true">»</span> </a> </li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
</div>
<!--foot-->
<%@include file="foot.jsp"%>
</body>
</html>
