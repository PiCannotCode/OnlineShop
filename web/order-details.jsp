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
        <title>Order detail</title>
        <link href="css/order.css" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="w3-bar">
            <b class="w3-left w3-padding">Order Details</b>
            <p class="w3-right w3-padding">Order_ID</p>
        </div>
        <div class="list" style="margin-left: 30px; margin-right: 30px;">
            <table class="table table-striped table-hover" >
                <thead class="thead">
                    <tr>
                        <th>ID</th>
                        <th>Create Date</th>
                        <th>Total price</th>
                        <th>Status</th>
                        <th>Note</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>2021/10/20</td>
                        <td>442$</td>
                        <td>Processing</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <c:forEach items="${list}" var="od">
            <h1>${od.id}</h1>
        </c:forEach>
        <b style="margin-left: 5%; font-size: 20px;">Details</b>
        <div class="row">
            <form action="checkout" method="post">
                <div class="col-sm-6">
                    <div class="total_area">
                        <div class="form-group" required style="margin-left: 5rem;">
                            <label>Tên người nhận</label>
                            <input name="name" type="text" class="form-control" required>
                        </div>
                        <div class="form-group" required style="margin-left: 5rem;">
                            <label>Số điện thoại người nhận</label>
                            <input name="phone" type="tel" pattern="[0]{1}[0-9]{9}" class="form-control" required>
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Địa chỉ nhận hàng</label>
                            <input name="address" type="text" class="form-control" required>
                        </div>
                        <div class="form-group" required style="margin-left: 5rem;">
                            <label>Email người nhận</label>
                            <input name="email" type="text" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="total_area" >
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Tổng tiền hàng</label>
                            <input name="totalprice" type="text" class="form-control" readonly="">
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Phí vận chuyển</label>
                            <input name="ship" type="text" class="form-control" placeholder="50,000" readonly="" required >
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>Tổng số tiền của đơn hàng</label>
                            <input name="totalpays" type="text" class="form-control" readonly="">
                        </div>
                        <div class="form-group" style="margin-left: 5rem;">
                            <label>VAT</label>
                            <input name="vat" type="text" class="form-control" placeholder="-10%" readonly="">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
