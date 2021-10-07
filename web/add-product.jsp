<%-- 
    Document   : add-product
    Created on : Oct 7, 2021, 6:19:27 AM
    Author     : DucAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <c:if test="${product eq null}">
            <title>Thêm sản phẩm</title>
        </c:if>
        <c:if test="${product ne null}">
            <title>Sửa sản phẩm</title>
        </c:if>

    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div id="main-contain" class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="img mg-top-15">
                        <img src="image/${product.image}">
                    </div>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-5">
                    
                    <c:if test="${product eq null}">
                        <form action="productservices?service=add" method="POST">
                    </c:if>
                    <c:if test="${product ne null}">
                        <form action="productservices?service=update&id=${product.id}" method="POST">
                    </c:if>
                                
                            <table>
                                <tr>
                                    <th>Tên sản phẩm: </th>
                                    <td><input type="text" name="name" placeholder="Nhập tên sản phẩm" value="${product.name}"></td>
                                </tr>
                                <tr>
                                    <th>Danh mục: </th>
                                    <td>
                                        <select name="category_id">
                                            <c:forEach items="${listCategory}" var="c">
                                                <option value="${c.id}">${c.category}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Giá : </th>
                                    <td><input type="text" name="price" placeholder="Nhập giá" value="${product.price}"></td>
                                </tr>
                                <tr>
                                    <th>Mô tả: </th>
                                    <td><input type="text" name="description" placeholder="Nhập mô tả" value="${product.description}"></td>
                                </tr>
                                <tr>
                                    <th>Số lượng: </th>
                                    <td><input type="text" name="quantity" placeholder="Nhập số lượng" value="${product.quantity}"></td>
                                </tr>
                                <tr>
                                    <th>Status: </th>
                                    <td><input type="text" name="status" placeholder="Nhập status" value="${product.status}"></td>
                                </tr>
                                <tr>
                                    <th>Ghi chú: </th>
                                    <td><input type="text" name="note" placeholder="Nhập ghi chú" value="${product.note}"></td>
                                </tr>
                            </table>
                                
                            <c:if test="${product eq null}">
                                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Thêm sản phẩm</button></div>
                            </c:if>
                            <c:if test="${product ne null}">
                                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Sửa sản phẩm</button></div>
                            </c:if>
                        </form>
                </div>
            </div>
        </div>
    </body>
</html>
