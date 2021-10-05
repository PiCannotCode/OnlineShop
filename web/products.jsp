<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link href="css/product.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div
            <a class="addProduct" href="AddProduct?id=${p.id}">Add Product</a>
        </div>
        <table border="1" align="center">
            <tr>
                <th class="thId">Id</th>
                <th class="thName">Tên</th>
                <th class="thcategory">Category_id</th>
                <th class="thPrice">Giá</th>
                <th class="thDescription">Mô tả</th>
                <th class="thQuantity">Số lượng</th>
                <th class="thStatus">Tình trạng</th>
                <th class="thImage">Ảnh</th>
                <th class="thNote">Ghi chú</th>
                <th class="thUpdate"></th>
                <th class="thDelete"></th>
            </tr>
            <c:forEach items="${listProduct}" var="p">
                <tr>
                    <td class="tdId">${p.id}</td>
                    <td class="tdName">${p.name}</</td>
                    <td class="tdcategory">${p.category_id}</td>
                    <td class="tdPrice">${p.price}</td>
                    <td>${p.description}</td>
                    <td class="tdQuantity">${p.quantity}</td>
                    <td class="tdStatus">${p.status}</td>
                    <td>${p.image}</td>
                    <td>${p.note}</td>
                    <td ><a class ="btnUpdate" href="UpdateProduct?id=${p.id}">Update</a></td>
                    <td ><a class ="btnDelete" href="productservices?service=delete&id=${p.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
