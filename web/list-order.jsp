<%-- 
    Document   : list-order
    Created on : Oct 29, 2021, 11:57:47 PM
    Author     : DucAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List order</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <table>
            <tr>
                <th>ID:</th>
                <th>Create Date:</th>
                <th>Name:</th>
                <th>Address:</th>
                <th>Phone:</th>
                <th>Total pay:</th>
            </tr>
            <c:forEach items="${listOrder}" var="o">
                <tr>
                    <td><a href="orderDetails?id=${o.id}">${o.id}</a></td>
                    <td>${o.date}</td>
                    <td>${o.name}</td>
                    <td>${o.address}</td>
                    <td>${o.phone}</td>
                    <td>${o.totalPay}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
