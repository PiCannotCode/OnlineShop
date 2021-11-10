<%-- 
    Document   : list-user
    Created on : 10-Nov-2021, 14:06:45
    Author     : HUY
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý người dùng</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="css/admin.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div style="margin-bottom: 20px">
                <h2 class="title text-center" style="margin-top: .7rem;">Danh sách người dùng</h2>
            </div>
            <div>
                <table class="table table-striped table-hover" >
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Email</th>
                            <th>Ngày tạo</th>
                            <th>Vai trò</th>
                            <th>Tình trạng</th>
                            <th>Tên người dùng</th>
                            <th>Số điện thoại</th>
                            <th>Giới tính</th>
                            <th>Địa chỉ</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listA}" var="a">
                            <tr>
                                <td>${a.id}</td>
                                <td>${a.email}</td>
                                <td>${a.createDate}</td>
                                <td>${a.role}</td>
                                <td>${a.status}</td>
                                <td>${a.name}</td>
                                <td>${a.phone}</td>
                                <td>${a.gender=='true'?"Nam":"Nữ"}</td>
                                <td>${a.address}</td>
                                <td>
                                    <a href="LoadAccount?id=${a.id}" class="settings" title="Settings" data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
                                    <a href="DeleteAccount?id=${a.id}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE5C9;</i></a>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
