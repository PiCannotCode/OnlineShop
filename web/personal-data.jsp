<%-- 
    Document   : UserProfile
    Created on : Oct 1, 2021, 7:51:28 AM
    Author     : DucAnh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin người dùng</title>
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
                    </div>
                </div>
                <div class="col-sm">
                    <div class="p-5">
                        <h3>Thông tin cá nhân</h3>
                        <div class="row mt-3">
                            <div class="personal-info">
                                <table>
                                    <tr>
                                        <td><b>Tên người dùng: &nbsp;</b></td>
                                        <td>${accDetail.name}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Giới tính:</b></td>
                                        <td>${accDetail.gender == 1? "Nam" : "Nữ"}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Số điện thoại:</b></td>
                                        <td>${accDetail.phone}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Địa chỉ:</b></td>
                                        <td>${accDetail.address}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="mt-5">
                            <button class="btn" style="background-color: #FE980F; color: white">Sửa thông tin</button>
                            <button class="btn" style="background-color: #FE980F; color: white">Đổi mật khẩu</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


