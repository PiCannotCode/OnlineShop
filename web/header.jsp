<%-- 
    Document   : header
    Created on : Sep 28, 2021, 9:12:44 PM
    Author     : SANG
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <header id="header"><!--header-->
            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 clearfix">
                            <div class="logo pull-left">
                                <a style="color: #FE980F; font-size: 18px;" href="home" class="active"><img src="//theme.hstatic.net/1000049508/1000480552/14/logo.png?v=267" style="width: 39%;"/></a>
                            </div>
                        </div>
                        <div class="col-md-9 clearfix">
                            <div class="shop-menu clearfix pull-right">
                                <ul class="nav navbar-nav">
                                    <c:choose>
                                        <c:when test="${currentAccount != null}">
                                            <li><a href="#">Hello: <b>${sessionScope.currentAccount.email}</b></a></li> 
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${currentAccount.roleId==1}">
                                            <li><a href="userlist"><i class="fa fa-list-alt"></i>Quản lý người dùng</a></li>
                                            </c:when>
                                            <c:when test="${currentAccount.roleId==3}">
                                            <li><a href="productservices?service=list"><i class="fa fa-list-alt"></i>Quản lý sản phẩm</a></li>
                                            <li><a href="orderListServlet"><i class="fa fa-list-alt"></i>Quản lý dơn hàng</a></li>
                                            </c:when>
                                        </c:choose>         
                                    <li><a href="#"><i class="fa fa-book"></i>Đơn hàng</a></li>
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                                        <c:choose>
                                            <c:when test="${currentAccount != null}">
                                            <li><a href="UserProfile?id=${currentAccount.accountDetailId}"><i class="fa fa-user"></i>Tài khoản</a></li>
                                            <li><a href="servicesaccount?service=logout"><i class="fa fa-sign-out"></i>Đăng xuất</a></li>
                                            </c:when>
                                            <c:when test="${currentAccount == null}">
                                            <li><a href="login.jsp"><i class="fa fa-sign-in"></i>Đăng nhập</a></li>
                                            </c:when>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="search_box pull-right">
                                <form action="productservices" method="Post">
                                    <input type="text" name="searchName" placeholder="Tên sản phẩm"/>
                                    <button style="padding: 7px; background-color: #FE980F; border-radius: 5px; border: none; color: white" type="submit">Tìm kiếm</button>
                                    <input name="service" type="hidden" value="search"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
