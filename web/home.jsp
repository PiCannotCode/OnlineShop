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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head><!--/head-->
    <body>
        <jsp:include page="header.jsp"/>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2 style="margin-top: .7rem;">Danh mục</h2>

                            <div class="panel-group category-products" id="accordian"><!--category-products-->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordian" href="#sportswear" class="collapsed">
                                                <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                                Balo
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="sportswear" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <c:forEach items="${cate}" var="c">
                                                <ul>
                                                    <li><a href="categoryService?id=${c.id}">${c.category} </a></li>
                                                </ul> 
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div><!--/category-products-->

                            <!--LAST PRODUCT-->
                            <div class="shipping text-center"><!--shipping-->
                                <img src="images/home/shipping.jpg" alt="" />
                            </div><!--/shipping-->
                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center" style="margin-top: .7rem;">Sản phẩm mới nhất</h2>
                            <c:forEach items="${listproduct}" var="p">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="image/${p.image}" alt="" />
                                                <h2>${p.price}</h2>
                                                <p><a href="ProductDetails?id=${p.id}">${p.name}</a></p>
                                                <a href="service=addtocart?id=${p.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
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