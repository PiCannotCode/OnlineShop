<%-- 
    Document   : editProfile
    Created on : 14-Oct-2021, 20:29:51
    Author     : HUY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa thông tin</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/personal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container mt-5">
            <a style="color: #FE980F" href="home"><b>Trang chủ</b></a>
            <div class="row">
                <div class="col-sm border-right">
                    <div class="text-center">
                        <img class="rounded-circle mt-5" width="175px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                        <h3><b>${accDetail.name}</b></h3>
                        <h4>${sessionScope.currentAccount.email}</h4>
                    </div>
                </div>
                <div class="col-sm">
                    <div class="p-5">
                        <h3>Sửa thông tin</h3>
                        <div class="row mt-3">
                            <form action="" method="">
                                <table align="center">
                                    <tr>
                                        <th>Tên người dùng: &nbsp;</th>
                                        <td><input type="text" name="name" value="${accDetail.name}"></td>
                                    </tr>
                                    <tr>
                                        <th>Số điện thoại:</th>
                                        <td><input type="text" name="phone" value="${accDetail.phone}"></td>
                                    </tr>
                                    <tr>
                                        <th>Giới tính:</th>
                                        <td>
                                            <input type="radio" name="gender" value="1" <c:if test="${accDetail.gender == 1}">checked</c:if> >Nam
                                            <input type="radio" name="gender" value="0" <c:if test="${accDetail.gender == 0}">checked</c:if> >Nữ
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Địa chỉ:</th>
                                        <td><input type="text" name="address" value="${accDetail.address}"></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><button type="submit" class="btn" style="background-color: #FE980F; color: white">Cập nhật</button></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
