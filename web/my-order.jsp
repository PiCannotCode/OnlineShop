<%-- 
    Document   : my-order
    Created on : 08-Nov-2021, 07:45:43
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đơn hàng của tôi</title>
        <link href="css/order.css" rel="stylesheet">
    </head>
    <body
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="orderlist" style="margin-bottom: 20px;">
                <b>Danh sách đơn hàng</b>
            </div>
            <div class="list" style="margin-left: 30px; margin-right: 30px;">
                <table class="table table-striped table-hover" >
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Ngày đặt hàng</th>
                            <th>Tổng số tiền</th>
                            <th>Trạng thái</th>
                            <th>Ghi chú</th>
                            <th>Chi tiết đơn hàng</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listOrder}" var="o">
                            <tr>
                                <td>${o.id}</a></td>
                                <td>${o.date}</td>
                                <td>${o.totalPay}</td>
                                <c:choose>
                                    <c:when test="${o.status == 1}"><td>Đang xử lí</td></c:when>
                                    <c:when test="${o.status == 2}"><td>Đang giao hàng</td></c:when>
                                    <c:when test="${o.status == 3}"><td>Giao hàng thành công</td></c:when>
                                    <c:when test="${o.status == 4}"><td>Đã hủy bỏ</td></c:when>
                                </c:choose>
                                <td>${o.note}</td>
                                <td><a href="OrderInfo?id=${o.id}">Xem chi tiết</a></td>
                                <c:choose>
                                    <c:when test="${o.status == 2}">
                                        <td><a class ="btnDeliver" style=" background-color: limegreen" href="orderProcess?id=${o.id}&status=3">Đã nhận hàng</a></td>
                                    </c:when>
                                    <c:when test="${o.status == 1}">
                                        <td><a class ="btnCancel" style=" background-color: red" href="orderProcess?id=${o.id}&status=4">Hủy đơn hàng</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td></td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:forEach>
                    </tbody>                  
                </table>
                <b><i>*Vui lòng nhấn "Đã nhận hàng" sau khi nhận được sản phẩm.</i></b>
            </div>
        </div>
    </body>
</html>
