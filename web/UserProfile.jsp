<%-- 
    Document   : UserProfile
    Created on : Sep 27, 2021, 4:51:35 AM
    Author     : DucAnh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h2 class="title text-center">Profile </h2>
        <form action="UpdateUserDetail" method="POST">
            <table align="center">
                <tr>
                    <th>Name:</th>
                    <td><input type="text" name="name" value="${accDetail.name}"></td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td><input type="text" name="phone" value="${accDetail.phone}"></td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td>
                        <input type="radio" name="gender" value="0" <c:if test="${accDetail.gender == 1}">checked</c:if> >Male
                        <input type="radio" name="gender" value="0" <c:if test="${accDetail.gender == 0}">checked</c:if> >Female
                    </td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td><input type="text" name="address" value="${accDetail.address}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit" >Update</button></td>
                </tr>
            </table>
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
