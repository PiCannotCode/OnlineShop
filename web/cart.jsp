<%-- 
    Document   : cart
    Created on : Oct 1, 2021, 10:24:17 PM
    Author     : SANG
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="entity.Cart"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Giỏ hàng</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head><!--/head-->

    <body style="background-image: url(images/bgbalo2.png); background-size: 100% 65%">
        <jsp:include page="header.jsp"/>
        <form action="CheckOut" method="post">
            <section id="cart_items">
                <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white;  margin-top: 20px">
                    <div class="table-responsive cart_info" style="margin-top: 20px">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Sản phẩm</td>
                                    <td class="price">Đơn giá</td>
                                    <td class="quantity">Số lượng</td>
                                    <td class="total">Số tiền</td>
                                    <td>Thao tác</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listCart}" var="l">
                                    <tr>
                                        <td class="cart_description">
                                            <h4><a href="productservices?service=details&id=${l.productId}">${l.name}</a></h4>
                                            <input type="hidden" name="Pname" value="${l.name}">
                                        </td>
                                        <td class="cart_price">
                                            <fmt:formatNumber type="number" value="${l.unitPrice}"/><sup></sup>
                                            <input type="hidden" name="Pname" value="${l.unitPrice}">
                                            <input type="hidden" name="Pid" value="${l.productId}">
                                            <input type="hidden" name="Pprice" value="${l.unitPrice}">
                                        </td>
                                        <td class="cart_quantity">
                                            <div class="cart_quantity_button">
                                                <a class="cart_quantity_down" href="CalculaterCart?service=1&id=${l.productId}"> - </a>
                                                <input class="cart_quantity_input" type="text" name="quantity" value="${l.quantity}" autocomplete="off" size="2">
                                                <a class="cart_quantity_up" href="CalculaterCart?service=2&id=${l.productId}"> + </a>
                                            </div>
                                        </td>
                                        <td class="cart_total">
                                            <p class="cart_total_price">
                                                <fmt:formatNumber type="number" value="${l.quantity * l.unitPrice}"/>
                                            </p>
                                        </td>
                                        <td class="cart_delete">
                                            <a class="cart_quantity_delete" href="CalculaterCart?service=0&id=${l.productId}"><i class="fa fa-times"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section> <!--/#cart_items-->

            <section id="do_action">
                <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white;  margin-top: 20px">
                    <div class="heading">
                        <h3>Thanh toán các mặt hàng trong giỏ</h3>
                        <p>Vui lòng điền đầy đủ các thông tin bên dưới để xác nhận đơn hàng, xin cảm ơn!</p>
                    </div>
                    <div class="row">

                        <div class="col-sm-6">
                            <div class="total_area" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white">
                                <div class="form-group" required style="margin-left: 1rem;">
                                    <label>Tên người nhận</label>
                                    <input name="name" type="text" class="form-control" value="${currentAccountDetail.name}" required>
                                </div>
                                <div class="form-group" required style="margin-left: 1rem;">
                                    <label>Số điện thoại người nhận</label>
                                    <input name="phone" type="tel" pattern="[0]{1}[0-9]{9}" class="form-control" value="${currentAccountDetail.phone}" required>
                                </div>
                                <div class="form-group" style="margin-left: 1rem;">
                                    <label>Địa chỉ nhận hàng</label>
                                    <input name="address" type="text" class="form-control" value="${currentAccountDetail.address}" required>
                                </div>
                                <div class="form-group" required style="margin-left: 1rem;">
                                    <label>Email người nhận</label>
                                    <input name="email" type="text" class="form-control" value="${currentAccount.email}">
                                </div>
                                <div class="form-group" required style="margin-left: 1rem;">
                                    <label>Ghi chú</label>
                                    <textarea name="note" type="text" class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="total_area" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white">
                                <div class="form-group" style="margin-left: 1rem;">
                                    <label>Tổng tiền hàng:</label><br>
                                    <fmt:formatNumber type="number" value="${totalprice}"/>
                                    <input name="totalprice" type="hidden" class="form-control" value="${totalprice}" readonly="" required ><sup>đ</sup>                                                                
                                </div>
                                <div class="form-group" style="margin-left: 1rem;">
                                    <label>Phí vận chuyển:</label><br>
                                    <fmt:formatNumber type="number" value="50000"/>
                                    <input name="ship" type="hidden" class="form-control" value="50000" readonly="" required ><sup>đ</sup>
                                </div>
                                <div class="form-group" style="margin-left: 1rem;">
                                    <label>Giảm giá:</label><br>
                                    <fmt:formatNumber type="number" value="0"/>
                                    <input name="vat" type="hidden" class="form-control" value="0" readonly=""><sup>đ</sup>
                                </div>
                                <div class="form-group" style="margin-left: 1rem;">
                                    <label>Tổng số tiền của đơn hàng:</label><br>
                                    <fmt:formatNumber type="number" value="${totalpays}"/>
                                    <input name="totalpays" type="hidden" value="${totalpays}" class="form-control" readonly=""><sup>đ</sup>
                                </div>
                                <div class="form-group" style="margin-left: 1rem;">
                                    <label>Hình thức thanh toán:</label><br>
                                    <input name="payments" type="radio" value="1" required checked/> Thanh toán khi nhận hàng<br>
                                    <input name="payments" type="radio" value="2" required disabled/> Chuyển khoản ngay <i>(Đang cập nhật)</i>                                  
                                </div>
                            </div>
                            <button class="btn btn-default check_out" onclick="return confirm('Xác nhận đặt hàng?')" style="margin-bottom: 15px; float: right">Đặt hàng</button>
                        </div>
                    </div>
                </div>
            </section><!--/#do_action-->
        </form>

        <jsp:include page="footer.jsp"/>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
