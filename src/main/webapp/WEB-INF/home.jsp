<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="<% out.print(request.getContextPath()); %>/assets/css/master.css">
        <script src="<% out.print(request.getContextPath()); %>/assets/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
    <div class="dark vh-100 vw-100 d-flex flex-column">

        <%@include file="includes/header.jsp"%>

        <%--            <jsp:include page="includes/header.jsp" >--%>
        <%--                <jsp:param name="user" value="${user}" />--%>
        <%--            </jsp:include>--%>

        <div class="d-flex flex-column flex-grow-1 p-5 gap-4 overflow-auto">
            <div>
                <img class="rounded-5" style="width:100%;max-height: 400px;object-fit: cover;" src="<% out.print(request.getContextPath()); %>/assets/images/food.png">
            </div>
            <div class="dark-secondary rounded-5 d-flex flex-grow-1 flex-column justify-content-center align-items-center h1 text-white">
                Welcome to symplicook the recipe application
            </div>

        </div>
    </div>
    </body>
</html>
