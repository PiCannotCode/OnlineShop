<%-- 
    Document   : order-details
    Created on : Nov 5, 2021, 12:55:48 AM
    Author     : DucAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${list}" var="od">
            <h1>${od.id}</h1>
            </c:forEach>
    </body>
</html>
