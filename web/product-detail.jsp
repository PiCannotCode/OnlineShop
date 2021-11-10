<%-- 
    Document   : product-detail
    Created on : Oct 3, 2021, 3:00:58 PM
    Author     : SANG
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Chi tiết sản phẩm</title>
    </head>
    <body style="background-image: url(images/bgbalo2.png); background-size: 100%">      
        <jsp:include page="header.jsp"/>
        <div id="main-contain" class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white; margin-top: 20px; margin-bottom: 20px">
            <div class="row">
                <div class="col-md-6">
                    <div class="img mg-top-15">
                        <img src="image/${product.image}" height="500" width="500">
                    </div>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-5">
                    <div class="product-details">
                        <h3 style="color: #FE980F;">${product.name}</h3>
                        <p style="font-size: 19px; font-weight: 700;"><fmt:formatNumber value="${product.price}"/><sup>đ</sup></p>
                        <c:if test="${currentAccount.roleId==2 || currentAccount.roleId==null}">
                            <c:choose>
                                <c:when test="${product.status == 'Còn hàng'}">
                                    <a href="cartservice?service=taketocart&id=${p.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
                                    </c:when>
                                    <c:otherwise>
                                    <button class="btn btn-default add-to-cart" disabled=""><i class="fa fa-shopping-cart"></i>Hết hàng</button>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        <div class="row">
                            <div class="col-md-12 info">
                                <p class="description bd-t pt-3">
                                <h4>Chi tiết sản phẩm:</h4>
                                <ul>
                                    <li>${product.description}</li>
                                </ul>
                                </p>
                                <p class="local bd-t pt-3">
                                <h4>Mua hàng trực tiếp tại địa chỉ:</h4>
                                <ul>
                                    <li>Đại học FPT - Khu Công nghệ cao Hòa Lạc,</li>
                                    <li>Xã Thạch Hoà, Huyện Thạch Thất, TP. Hà Nội.</li>
                                </ul>
                                </p>
                                <p class="refund bd-t pt-3">
                                <h4>Giao hàng và trả lại hàng theo các hình thức sau:</h4>
                                <ul>
                                    <li>Đổi trả trong vòng 48h.</li>
                                    <li>Phí vận chuyển toàn quốc: 50.000 VNĐ. </li>
                                    <li>Cho xem hàng trước khi thanh toán.</li>
                                </ul> 
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>
        <script src="js/jquery/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="js/bootstrap/bootstrap.min.js"></script>
    </body>
</html>




