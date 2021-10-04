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
        
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-6 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Sanghocgioi</span><span class="text-black-50">santiennguci@gmail.com</span><span> </span></div>
                </div>
                <div class="col-md-6 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Thông tin cá nhân</h4>
                        </div>
                        <div class="row mt-3">
                            <div class="personal-info">
                                <table>
                                    <tr>
                                        <td>Tên người dùng:</td>
                                        <td>${accDetail.name}</td>
                                    </tr>
                                    <tr>
                                        <td>Số điện thoại:</td>
                                        <td>${accDetail.phone}</td>
                                    </tr>
                                    <tr>
                                        <td>Giới tính:</td>
                                        <td>${accDetail.gender == 1 ? "Nam" : "Nữ"}</td> 
                                    </tr>
                                    <tr>
                                        <td>Địa chỉ:</td>
                                        <td>${accDetail.address}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Lưu thông tin</button></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


