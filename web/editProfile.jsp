<%-- 
    Document   : editProfile
    Created on : 14-Oct-2021, 20:29:51
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa thông tin</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="css/personal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-image: url(images/bgbalo2.png); background-size: 100%">
        <jsp:include page="header.jsp"/>
        <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white;  margin-top: 20px; margin-bottom: 50px; min-height: 500px; border-radius: 5px 5px 5px 5px">
            <div class="col-sm-5">
                <div class="text-center">
                    <img class="rounded-circle mt-5" width="250px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                    <h3>${currentAccountDetail.name}</h3>
                </div>
            </div>
            <form action="EditProfile?id=${currentAccountDetail.id}" method="post">
                <div class="col-sm-6" style="margin-top: 30px">
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" readonly value="${currentAccount.email}">
                    </div>
                    <div class="form-group">
                        <label>Tên người dùng</label>
                        <input class="form-control" type="text" name="name" required value="${currentAccountDetail.name}">
                    </div>
                    <div class="form-group">
                        <label>Số điện thoại</label>
                        <input class="form-control" type="tel" pattern="[0]{1}[0-9]{9}" name="phone" required value="${currentAccountDetail.phone}">
                    </div>
                    <div class="form-group">
                        <label>Giới tính</label><br>
                        <input type="radio" name="gender" required="" value="1" <c:if test="${currentAccountDetail.gender == 1}">checked</c:if> >&ensp;Nam
                        <input type="radio" name="gender" required="" value="0" style="margin-left: 30px"<c:if test="${currentAccountDetail.gender == 0}">checked</c:if> >&ensp;Nữ
                        </div>
                        <div class="form-group">
                            <label>Địa chỉ</label>
                            <input class="form-control" type="text" name="address" required value="${currentAccountDetail.address}">
                    </div>
                    <div class="button1">
                        <button type="submit" class="btn" style="background-color: #FE980F; color: white">Cập nhật</button>
                    </div>
                </div>  
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
