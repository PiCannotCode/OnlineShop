<%-- 
    Document   : user-profile
    Created on : 11-Nov-2021, 23:00:07
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin người dùng</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="css/personal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-image: url(images/bgProfile.png); background-size: 100%">
        <jsp:include page="header.jsp"/>
        <div class="container" style="box-shadow: 5px 5px 5px 1px #cccccc; background-color: white;  margin-top: 20px; margin-bottom: 50px; min-height: 500px; border-radius: 5px 5px 5px 5px">
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
            <div class="col-sm-5">
                <div class="text-center">
                    <img class="rounded-circle mt-5" width="250px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                    <h3>${currentAccountDetail.name}</h3>
                </div>
            </div>
            <div class="col-sm-6" style="margin-top: 30px">
                <div class="personal-info">
                    <table>
                        <tr>
                            <td><b>Email:</b></td>
                            <td>${currentAccount.email}</td>
                        </tr>
                        <tr>
                            <td><b>Tên người dùng: &nbsp;</b></td>
                            <td>${currentAccountDetail.name}</td>
                        </tr>
                        <tr>
                            <td><b>Số điện thoại:</b></td>
                            <td>${currentAccountDetail.phone}</td>
                        </tr>
                        <tr>
                            <td><b>Giới tính:</b></td>
                            <td>${currentAccountDetail.gender == 1? "Nam" : "Nữ"}</td>
                        </tr>
                        <tr>
                            <td><b>Địa chỉ:</b></td>
                            <td>${currentAccountDetail.address}</td>
                        </tr>
                    </table>
                </div>
                <div class="button2">
                    <a href="editProfile.jsp" class="btn b" style="background-color: #FE980F; color: white; ">Sửa thông tin</a>
                    <a href="changePass.jsp" class="btn" style="background-color: #FE980F; color: white">Đổi mật khẩu</a>
                </div>
            </div>        
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
