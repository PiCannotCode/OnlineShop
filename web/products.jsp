<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách sản phẩm</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="css/product.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div style="margin-bottom: 20px;">
            <a class="addProduct" href="productservices?service=addview">Thêm sản phẩm mới</a>
        </div>
        <div style="margin-left: 30px; margin-right: 30px;">
            <form action="productservices?service=deleteCheckbox" method="POST">
                <table class="table table-striped table-hover" >
                    <thead >
                        <tr>
                            <th class="thId">Id</th>
                            <th class="thName">Tên sản phẩm</th>
                            <th class="thcategory">Category_id</th>
                            <th class="thPrice">Đơn giá</th>
                            <th class="thDescription">Mô tả chi tiết</th>
                            <th class="thQuantity">Số lượng</th>
                            <th class="thStatus">Tình trạng</th>
                            <th class="thImage">Ảnh</th>
                            <th class="thNote">Ghi chú</th>
                            <th class="thUpdate" colspan="3">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listProduct}" var="p">
                            <tr>
                                <td class="tdId">${p.id}</td>
                                <td class="tdName">${p.name}</</td>
                                <td class="tdcategory">${p.category_id}</td>
                                <td class="tdPrice"><fmt:formatNumber value="${p.price}"/><sup>đ</sup></td>
                                <td>${p.description}</td>
                                <td class="tdQuantity">${p.quantity}</td>
                                <td class="tdStatus">${p.status}</td>
                                <td><img src="image/${p.image}" style="width: 130px;"></td>
                                <td>${p.note}</td>
                                <td><a class ="btnUpdate" href="productservices?service=updateview&id=${p.id}">Sửa</a></td>
                                <td><a onclick="return confirm('Mặt hàng này sẽ được xóa')" class ="btnDelete" href="productservices?service=delete&id=${p.id}">Xóa</a></td>
                                <td><input type="checkbox" name="deleteCheckbox" value="${p.id}"></td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
                <button type="Submit">Xóa các sản phẩm đã chọn</button>
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
