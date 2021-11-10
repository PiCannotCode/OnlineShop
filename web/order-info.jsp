<%-- 
    Document   : order-info
    Created on : 09-Nov-2021, 20:22:15
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết đơn hàng</title>
        <link href="css/order.css" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body style="background-image: url(images/bgbalo2.png); background-size: 100%">
        <jsp:include page="header.jsp"/>
        <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white;  margin-top: 20px; margin-bottom: 50px">
            <div class="w3-bar" style="margin-top: 15px">
                <b class="w3-left w3-padding">Chi tiết Đơn hàng</b>
                <p class="w3-right w3-padding">Trạng thái: 
                    <c:if test="${order.status == 1}">Đang xử lý</c:if>
                    <c:if test="${order.status == 2}">Đang giao hàng</c:if>
                    <c:if test="${order.status == 3}">Giao hàng thành công</c:if>
                    <c:if test="${order.status == 4}">Đã hủy bỏ</c:if></p>
                </div>
                <div class="list" style="margin-left: 30px; margin-right: 30px;">
                    <table class="table table-striped table-hover" >
                        <thead class="thead">
                            <tr>
                                <th>ID</th>
                                <th>Tên sản phẩm</th>
                                <th>Số lượng</th>
                                <th>Đơn giá</th>
                                <th>Số tiền</th>
                            <c:if test="${order.status == 3}"><th>Đánh giá</th></c:if>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="od">
                            <tr>
                                <td>${od.id}</td>
                                <td>${od.productName}</td>
                                <td>${od.productQuantity}</td>
                                <td>${od.productPrice}</td>
                                <td>${od.productPrice * od.productQuantity}</td>
                                <c:if test="${order.status == 3}"><th><a href="#">Đánh giá</a></th></c:if>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="col-sm-6">
                <div class="form-group">
                    <label>Tên người nhận:</label>
                    <input class="form-control" readonly value="${order.name}">
                </div>
                <div class="form-group">
                    <label>Số điện thoại người nhận</label>
                    <input class="form-control" readonly value="${order.phone}">
                </div>
                <div class="form-group">
                    <label>Địa chỉ nhận hàng</label>
                    <input class="form-control" readonly value="${order.address}">
                </div>
                <div class="form-group">
                    <label>Email người nhận</label>
                    <input class="form-control" readonly value="${order.email}">
                </div>
                <div class="form-group">
                    <label>Ghi chú</label>
                    <textarea class="form-control" readonly>${order.note}</textarea>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label>Tổng tiền hàng</label>
                    <input class="form-control" readonly value="${order.totalPrice}">
                </div>
                <div class="form-group">
                    <label>Phí vận chuyển</label>
                    <input class="form-control" readonly value="${order.ship}">
                </div>
                <div class="form-group">
                    <label>Giảm giá</label>
                    <input class="form-control" readonly value="${order.vat}">
                </div>
                <div class="form-group">
                    <label>Tổng số tiền của đơn hàng</label>
                    <input class="form-control" readonly value="${order.totalPay}">
                </div>          
                <div class="form-group">
                    <label>Hình thức thanh toán</label>
                    <input class="form-control" readonly 
                           value="<c:if test="${order.payments == 1}">Thanh toán khi nhận hàng</c:if>
                           <c:if test="${order.payments == 2}">Chuyển khoản</c:if>">
                </div>
            </div>
                               <a href="MyOrderServlet?id=${currentAccount.id}" class="btn" style="margin-left: 90%; margin-bottom: 20px; background-color: #FE980F; color: white">Quay lại</a>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
