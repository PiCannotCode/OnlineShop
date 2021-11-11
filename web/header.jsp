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
        <header id="header" style="margin-top: 1px; background-color: #FF9900; box-shadow: 0px 5px 1px 1px #999999"><!--header-->
            <div class="header-middle">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 clearfix">
                            <div class="logo pull-left">
                                <a href="home" class="active"><img src="images/logo2.png" style="width: 50%;"/></a>
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
                                            <li><a href="orderListServlet"><i class="fa fa-list-alt"></i>Quản lý đơn hàng</a></li>
                                            <li><a href="productservices?service=list"><i class="fa fa-list-alt"></i>Quản lý sản phẩm</a></li>                                           
                                            </c:when>
                                            <c:when test="${currentAccount.roleId==2}">
                                            <li><a href="MyOrderServlet?id=${currentAccount.id}"><i class="fa fa-book"></i>Đơn hàng</a></li>
                                            <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${currentAccount != null}">
                                            <li><a href="user-profile.jsp"><i class="fa fa-user"></i>Tài khoản</a></li>
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
            </div>           
        </header><!--/header-->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
