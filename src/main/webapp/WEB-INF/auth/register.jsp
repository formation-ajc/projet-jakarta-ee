<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="<% out.print(request.getContextPath()); %>/assets/css/master.css">
    <script src="<% out.print(request.getContextPath()); %>/assets/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="auth vh-100 vw-100 d-flex justify-content-center align-items-center">

        <form action="<% out.print(request.getContextPath()); %>/register" method="POST" class="connection-card p-5 d-flex gap-3 justify-content-center align-items-center flex-column rounded-3">
            <span style="font-size: 50px" class="material-symbols-outlined">app_registration</span>
            <div class="h3 ">Please sign up</div>
            <div class="input-group flex-nowrap">
<%--                <span class="input-group-text material-symbols-outlined" id="Email">alternate_email</span>--%>
                <input name="firstname" type="text" class="form-control" placeholder="Firstname" aria-label="Firstname" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <%--                <span class="input-group-text material-symbols-outlined" id="Email">alternate_email</span>--%>
                <input name="lastname" type="text" class="form-control" placeholder="Lastname" aria-label="Lastname" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text material-symbols-outlined" id="Email">alternate_email</span>
                <input name="email" type="text" class="form-control" placeholder="Email" aria-label="Email" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text material-symbols-outlined" id="Password">lock</span>
                <input name="password" type="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text material-symbols-outlined" id="ConfirmPassword">lock</span>
                <input name="confirmPassword" type="password" class="form-control" placeholder="Comfirm password" aria-label="ConfirmPassword" aria-describedby="addon-wrapping">
            </div>
            <div class="text-danger">
                ${error}
            </div>
            <div class="d-flex gap-2 justify-content-center align-items-center w-100">
                <a class="btn btn-light" href="<% out.print(request.getContextPath()); %>/login">
                    <span class="material-symbols-outlined">
                        chevron_left
                    </span>
                </a>
                <button type="submit" class="btn btn-primary w-100">Sign up</button>
            </div>
        </form>
    </div>
</body>
</html>