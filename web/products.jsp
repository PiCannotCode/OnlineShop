<%-- 
    Document   : products
    Created on : Sep 27, 2021, 5:20:47 PM
    Author     : SANG
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page products of Seller, Hello Seller ${currentAccount}!</h1>
        <a href="AddProduct?id=${p.id}">Add Product</a>
        <table border="1" align="center">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>category_id</th>
                <th>price</th>
                <th>description</th>
                <th>quantity</th>
                <th>status</th>
                <th>image</th>
                <th>note</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${listProduct}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</</td>
                    <td>${p.category_id}</td>
                    <td>${p.price}</td>
                    <td>${p.description}</td>
                    <td>${p.quantity}</td>
                    <td>${p.status}</td>
                    <td>${p.image}</td>
                    <td>${p.note}</td>
                    <td><a href="UpdateProduct?id=${p.id}">Update</a></td>
                    <td><a href="productservices?service=delete&id=${p.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
