<%-- 
    Document   : list-order
    Created on : Oct 29, 2021, 11:57:47 PM
    Author     : DucAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách đơn hàng</title>
        <link href="css/order.css" rel="stylesheet">
    </head>
    <body style="background-image: url(images/bgOrder.png); background-size: 100%">
        <jsp:include page="header.jsp"/>
        <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white;  margin-top: 20px; margin-bottom: 50px; min-height: 500px">
            <div class="orderlist" style="margin-bottom: 20px; margin-top: 20px">
                <b>Danh sách đơn hàng</b>
            </div>
            <div class="list" style="margin-left: 30px; margin-right: 30px;">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Account_ID</th>
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
                                <td>${o.accountId}</td>
                                <td>${o.date}</td>
                                <td><fmt:formatNumber type="number" value="${o.totalPay}"/><sup>đ</sup></td>
                                <c:choose>
                                    <c:when test="${o.status == 1}"><td>Đang xử lí</td></c:when>
                                    <c:when test="${o.status == 2}"><td>Đang giao hàng</td></c:when>
                                    <c:when test="${o.status == 3}"><td>Giao hàng thành công</td></c:when>
                                    <c:otherwise><td>Đã hủy bỏ</td></c:otherwise>
                                </c:choose>
                                <td>${o.note}</td>
                                <td><a href="orderDetails?id=${o.id}">Xem chi tiết</a></td>
                                <c:choose>
                                    <c:when test="${o.status == 1}">
                                        <td><a class ="btnDeliver" style=" background-color: limegreen" href="orderProcess?id=${o.id}&status=2">Đang giao hàng</a></td>
                                    </c:when>
                                    <c:when test="${o.status == 4 || o.status == 5}">
                                        <td><a class ="btnDelete" style=" background-color: gray" href="deleteOrder?id=${o.id}">Xóa khỏi danh sách</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td></td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
