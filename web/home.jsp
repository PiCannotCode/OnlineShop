<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head><!--/head-->
    <body style="background-image: url(images/bgbalo2.png); background-size: 100% 45%">
        <jsp:include page="header.jsp"/>

        <section>
            <div class="header-bottom"><!--search bar-->
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
                                    <button style="padding: 7px; background-color: #FE980F; border-radius: 5px; border: none; color: white" type="submit"><i class="fa fa-search"></i></button>
                                    <input name="service" type="hidden" value="search"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/search bar-->

            <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white;  margin-bottom: 20px">
                <div class="row" style="margin-top: 20px">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2 style="margin-top: .7rem;">Danh mục</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-products-->
                                <div class="panel panel-default">
                                    <c:forEach items="${cate}" var="c">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordian" href="#sportswear" class="collapsed">
                                                    <li><a href="categoryService?id=${c.id}">${c.category} </a></li>
                                                </a>
                                            </h4>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div><!--/category-products-->

                            <!--LAST PRODUCT-->
                            <div class="title text-center">
                                <p style="color: #FE980F; font-size: 18px; font-weight: 700;">Sản phẩm bán chạy nhất</p>
                                <a href="productservices?service=details&id=${newproduct.id}"><img src="image/${newproduct.image}" style="width: 240px; padding-left:  0px;" /></a>
                            </div>

                            <div class="shipping text-center"><!--shipping-->
                                <img src="images/home/shipping.jpg" alt="" />
                            </div><!--/shipping-->

                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center" style="margin-top: .7rem;">Sản phẩm mới nhất</h2>
                            <c:if test="${empty listproduct}"><h4 style="text-align: center">Sản phẩm đang được cập nhật</h4></c:if>
                            <c:forEach items="${listproduct}" var="p">
                                <div class="col-sm-3">
                                    <div class="product-image-wrapper" style="box-shadow: 1px 1px 10px 1px #cccccc">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="image/${p.image}" alt="" style="height: 180px; width: 180px"/>
                                                <h2><fmt:formatNumber value="${p.price}"/><sup>đ</sup></h2>
                                                <p><a href="productservices?service=details&id=${p.id}">${p.name}</a></p>     
                                                    <c:if test="${currentAccount.roleId==2 || currentAccount.roleId==null}">
                                                        <c:choose>
                                                            <c:when test="${p.status == 'Còn hàng'}">
                                                            <a href="cartservice?service=taketocart&id=${p.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button class="btn btn-default add-to-cart" disabled=""><i class="fa fa-shopping-cart"></i>Hết hàng</button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:if>    
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div><!--features_items-->
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"/>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>