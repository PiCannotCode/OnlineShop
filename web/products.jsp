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
    <body style="background-image: url(images/bgbalo2.png); background-size: 100% 27%">
        <jsp:include page="header.jsp"/>
        <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: whitesmoke; margin-top: 20px; margin-bottom: 20px; min-height: 500px">
            <c:if test="${message != null}">
                <div class="alert alert-success" role="alert" style="margin-top: 10px">
                    <p style="text-align: center">${message}</p>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <c:if test="${error != null}">
                <div class="alert alert-danger" role="alert" style="margin-top: 10px">
                    <p style="text-align: center">${error}</p>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <div style="margin-bottom: 20px; margin-top: 20px">
                <h2 class="title text-center" style="margin-top: .7rem;">Danh sách sản phẩm</h2>
                <a style="margin-left: 86%" class="btn btn-info" href="productservices?service=addview">Thêm sản phẩm mới</a>
            </div>
            <div>
                <form action="productservices?service=deleteCheckbox" method="POST">
                    <table class="table table-striped table-hover">
                        <thead >
                            <tr>
                                <th class="thId">Id</th>
                                <th class="thName">Tên sản phẩm</th>
                                <th class="thcategory">Danh mục</th>
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
                                    <td class="tdName">${p.name}</td>
                                    <c:forEach items="${listCategory}" var="c">
                                        <c:if test="${c.id == p.category_id}"><td class="tdcategory">${c.category}</td></c:if>
                                    </c:forEach>
                                    <td class="tdPrice"><fmt:formatNumber value="${p.price}"/><sup>đ</sup></td>
                                    <td class="tdDescription">${p.description}</td>
                                    <td class="tdQuantity">${p.quantity}</td>
                                    <td class="tdStatus">${p.status}</td>
                                    <td><img src="image/${p.image}" width="130" height="130"></td>
                                    <td>${p.note}</td>
                                    <td><a href="productservices?service=updateview&id=${p.id}"><i class="material-icons">&#xE8B8;</i></a></td>
                                    <td><a onclick="return confirm('Mặt hàng này sẽ được xóa')" href="productservices?service=delete&id=${p.id}" style="color: #F44336"><i class="material-icons">&#xE5C9;</i></a></td>
                                    <td><input type="checkbox" name="deleteCheckbox" value="${p.id}"></td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <button style="margin-left: 83%; margin-bottom: 10px" class="btn btn-warning" type="Submit" onclick="return confirm('Những mặt hàng này sẽ được xóa')">Xóa các sản phẩm đã chọn</button>
                </form>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
