<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Đăng ký</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style_1.css">
    </head>
    <body class="img js-fullheight" style="background-image: url(images/bg.jpg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Tạo tài khoản</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <p style="text-align: center;">${message}</p>
                            <form action="servicesaccount" method="post">     
                                <div class="form-group">
                                    <input name="email" type="text" class="form-control" placeholder="Email" required>
                                </div>
                                <div class="form-group">
                                    <input name="password" type="password" class="form-control" placeholder="Mật khẩu" required>
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <input name="repassword" type="password" class="form-control" placeholder="Nhập lại mật khẩu" required>
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <input name="name" type="text" class="form-control" placeholder="Tên người dùng" required>
                                </div>
                                <div class="form-group">
                                    <input name="phone" type="tel" pattern="[0]{1}[0-9]{9}" class="form-control" placeholder="Số điện thoại" required>
                                </div>
                                <div class="form-group">
                                    <input name="address" type="text" class="form-control" placeholder="Địa chỉ" required>
                                    <div class="form-group">
                                        <div class="col">
                                            <label>
                                                <input type="radio" value="1" name="gender" required="">
                                                <span>Nam</span>
                                            </label>
                                            <label>
                                                <input type="radio" value="0" name="gender" required="">
                                                <span>Nữ</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="form-control btn btn-primary submit px-3">Đăng ký</button>
                                    <input name="service" type="hidden" value="register" />
                                </div>
                            </form>
                            <p class="w-100 text-center">&mdash; Hoặc &mdash;</p>
                            <div class="social d-flex text-center">
                                <a href="login.jsp" class="px-2 py-2 mr-md-1 rounded">Đăng nhập</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>

