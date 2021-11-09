<%-- 
    Document   : order-details
    Created on : Nov 5, 2021, 12:55:48 AM
    Author     : DucAnh
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
    <body>
        <jsp:include page="header.jsp"/>
        <div class="w3-bar">
            <b class="w3-left w3-padding">Chi tiết Đơn hàng</b>
            <p class="w3-right w3-padding">Mã đơn hàng : ${order.id}</p>
        </div>
        <div class="container">
            <div class="list" style="margin-left: 30px; margin-right: 30px;">
                <table class="table table-striped table-hover" >
                    <thead class="thead">
                        <tr>
                            <th>ID: </th>
                            <th>Tên sản phẩm </th>
                            <th>Số lượng: </th>
                            <th>Giá 1 sản phẩm: </th>
                            <th>Tổng tiền sản phẩm: </th>
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <b style="margin-left: 5%; font-size: 20px;">Details</b>
        <div class="row">
            <form action="checkout" method="post">
                <div class="col-sm-6">
                    <div class="total_area">
                        <div class="form-group" required style="margin-left: 5rem;">
                            <label>Tên người nhận</label>
                            <input name="name" type="text" class="form-control" readonly="" value="${order.name}">
                        </div>
                        <div class="form-group" required style="margin-left: 5rem;">
                            <label>Số điện thoại người nhận</label>
                            <input name="phone" type="tel" pattern="[0]{1}[0-9]{9}" class="form-control" readonly="" value="${order.phone}">
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Địa chỉ nhận hàng</label>
                            <input name="address" type="text" class="form-control" readonly="" value="${order.address}">
                        </div>
                        <div class="form-group" required style="margin-left: 5rem;">
                            <label>Email người nhận</label>
                            <input name="email" type="text" class="form-control" readonly="" value="${order.email}">
                        </div>
                        <div class="form-group" required style="margin-left: 5rem;">
                            <label>Ghi chú</label>
                            <textarea name="note" type="text" class="form-control" readonly="" >${order.note}</textarea>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="total_area" >
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Tổng tiền hàng</label>
                            <input name="totalprice" type="text" class="form-control" readonly="" value="${order.totalPrice}">
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Phí vận chuyển</label>
                            <input name="ship" type="text" class="form-control" placeholder="50,000" readonly="" value="${order.ship}">
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Tổng số tiền của đơn hàng</label>
                            <input name="totalpays" type="text" class="form-control" readonly="" value="${order.totalPay}">
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>VAT</label>
                            <input name="vat" type="text" class="form-control" placeholder="0" readonly="" value="${order.vat}">
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Hình thức thanh toán</label>
                            <input name="payments" type="text" class="form-control" readonly="" 
                                   value="<c:if test="${order.payments == 1}">Tiền mặt</c:if>
                                   <c:if test="${order.payments == 2}">Chuyển khoản</c:if>">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
