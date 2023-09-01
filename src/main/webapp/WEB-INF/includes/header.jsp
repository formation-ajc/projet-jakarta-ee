<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header p-3 d-flex gap-3 align-items-center justify-content-between">
    <div class="d-flex align-items-center justify-content-center gap-4">
        <span style="font-size: 50px" class="material-symbols-outlined text-white">food_bank</span>
        <div style="font-size: 40px" class="text-white">SIMPLYCOOK</div>
    </div>

    <div class="d-flex gap-5 align-items-center">
        <ul class="nav nav-underline gap-5">
            <li class="nav-item">
                <a style="font-size:25px" class="nav-link text-white" href="<% out.print(request.getContextPath()); %>/home">Home</a>
            </li>
            <li class="nav-item">
                <a style="font-size:25px" class="nav-link text-white" href="<% out.print(request.getContextPath()); %>/recipe">Recipes</a>
            </li>
        </ul>

        <div class="dropdown">
            <button style="border: 0" class="transparent btn btn-dark dropdown-toggle d-flex justify-content-center align-items-center" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                <span style="font-size: 35px" class="material-symbols-outlined text-white">account_circle</span>
            </button>
            <ul class="dropdown-menu">

            <c:choose>
                <c:when test='<%= request.getSession().getAttribute("user") == null %>'>
                    <li>
                        <div class="d-flex flex-column gap-2 p-2">
                            <a href="<% out.print(request.getContextPath()); %>/login" class="btn btn-success w-100 primary border-0">Sign in</a>
                            <a href="<% out.print(request.getContextPath()); %>/register" class="btn btn-info w-100 blue border-0 text-white">Sign up</a>
                        </div>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="d-flex justify-content-center align-items-center text-white">
                            ${user.getFirstname()} ${user.getLastname()}
                    </li>
                    <li><hr class="dropdown-divider"></li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center text-white" href="user/profile">
                            <span class="material-symbols-outlined">person</span>&nbsp;
                            Profile
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center text-white" href="#">
                            <span class="material-symbols-outlined">settings</span>&nbsp;
                            Parameter
                        </a>
                    </li>
                    <li>
                        <form style="margin:0" action="<% out.print(request.getContextPath()); %>/user/logout" method="post" class="d-flex justify-content-center align-items-center p-2">
                            <button type="submit" class="btn btn-danger w-100">Logout</button>
                        </form>
                    </li>
                </c:otherwise>
            </c:choose>
            </ul>
        </div>
    </div>
</div>
