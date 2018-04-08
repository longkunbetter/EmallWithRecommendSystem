<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="search">
                <form>
                    <input type="text" value="每日推荐" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '每日推荐';}">
                    <input type="submit" value="搜索">
                </form>
            </div>
            <div class="header-left">
                <c:choose>
                    <c:when test="${sessionScope.loginInfo!=null}">
                        <ul>
                            <li ><a href="#">你好,${sessionScope.loginInfo.username}</a></li>
                            <li><a  href="/common/user/loginout">退出登录</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul>
                            <li ><a href="login">登录</a></li>
                            <li><a  href="register">注册</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>

                <div class="cart box_1">
                    <a href="checkout">
                        <h3> <div class="total">
                            <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
                            <img src="${pageContext.request.contextPath}/images/cart.png" alt=""/></h3>
                    </a>
                    <p><a href="javascript:;" class="simpleCart_empty">清空购物车</a></p>

                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="container">
        <div class="head-top">
            <div class="logo">
                <a href="/index"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""></a>
            </div>
            <div class=" h_menu4">
                <ul class="memenu skyblue">
                    <li class="active grid"><a class="color8" href="/index">首页</a></li>
                    <c:forEach items="${applicationScope.meunData}" var="item" varStatus="status">
                        <li>
                            <a class="color${(status.index)+1}" href="#">${item.name}</a>
                            <div class="mepanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul>
                                                <c:forEach items="${item.subCategorizes}" var="subItem" varStatus="subStatus">
                                                    <li><a href="/search/${subItem.id}">${subItem.name}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul>
                                                <li><a href="products.html">Shirts</a></li>
                                                <li><a href="products.html">Shoes, Boots & Trainers</a></li>
                                                <li><a href="products.html">Vests</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul>
                                                <li><a href="products.html">Shirts</a></li>
                                                <li><a href="products.html">Shoes, Boots & Trainers</a></li>
                                                <li><a href="products.html">Vests</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>

</div>