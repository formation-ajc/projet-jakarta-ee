<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="<% out.print(request.getContextPath()); %>/assets/css/master.css">
    <script src="<% out.print(request.getContextPath()); %>/assets/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="dark vh-100 vw-100 d-flex flex-column">

    <%@include file="../includes/header.jsp"%>

    <%--            <jsp:include page="includes/header.jsp" >--%>
    <%--                <jsp:param name="user" value="${user}" />--%>
    <%--            </jsp:include>--%>

    <div class="d-flex flex-column flex-grow-1 p-5 gap-4 overflow-auto justify-content-center align-items-center">

        <form action="<% out.print(request.getContextPath()); %>/user/profile" method="POST" class="dark-secondary p-5 d-flex gap-3 justify-content-center align-items-center flex-column rounded-3">
            <span style="font-size: 50px" class="material-symbols-outlined text-white">face</span>
            <div class="h3 text-white">My profile</div>
            <div class="input-group flex-nowrap">
                <%--                <span class="input-group-text material-symbols-outlined" id="Email">alternate_email</span>--%>
                <input value="${user.getFirstname()}" name="firstname" type="text" class="form-control white" placeholder="Firstname" aria-label="Firstname" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <%--                <span class="input-group-text material-symbols-outlined" id="Email">alternate_email</span>--%>
                <input value="${user.getLastname()}" name="lastname" type="text" class="form-control white" placeholder="Lastname" aria-label="Lastname" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text material-symbols-outlined neutral" id="Email">alternate_email</span>
                <input value="${user.getEmail()}" name="email" type="text" class="form-control white" placeholder="Email" aria-label="Email" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text material-symbols-outlined neutral" id="Password">lock</span>
                <input name="password" type="password" class="form-control white" placeholder="Password" aria-label="Password" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text material-symbols-outlined neutral" id="ConfirmPassword">lock</span>
                <input name="confirmPassword" type="password" class="form-control white" placeholder="Comfirm password" aria-label="ConfirmPassword" aria-describedby="addon-wrapping">
            </div>
            <div class="text-danger">
                ${error}
            </div>
            <div class="d-flex gap-2 justify-content-center align-items-center w-100">
                <button type="submit" class="btn btn-primary w-100">Modify</button>
            </div>
        </form>


    </div>
</div>
</body>
</html>
