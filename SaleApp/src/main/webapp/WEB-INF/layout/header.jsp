<%-- 
    Document   : header
    Created on : 19 thg 7, 2022, 21:20:12
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--<div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
    <div class="spinner-border text-primary" role="#"></div>
</div>-->




<div class="container-fluid fixed-top px-0 wow fadeIn" data-wow-delay="0.1s">   
    <nav class="navbar navbar-expand-lg navbar-light py-lg-0 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
        <a href="<c:url value="/"/>" class="navbar-brand ms-4 ms-lg-0">
            <h1 class="fw-bold text-primary m-0">F<span class="text-secondary">oo</span>dy</h1>
        </a>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <a href="#" class="nav-item nav-link active">Home</a>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <a href="<c:url value="/login" />" class="nav-item nav-link">Đăng Nhập</a> 
                    <a href="<c:url value="/register" />" class="nav-item nav-link">Đăng Ký</a>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a href="<c:url value="/" />" class="nav-item nav-link">
                        ${pageContext.request.userPrincipal.name}
                    </a>
                    <a href="<c:url value="/logout" />" class="nav-item nav-link">
                        Logout
                    </a>
                </c:if>

            </div>
            <div class="d-none d-lg-flex ms-2">

                
                <a class="btn-sm-square bg-white rounded-circle ms-3"  href="<c:url value="/cart"/>" >
                    <i style=" font-size: 50px" class="fa fa-shopping-bag text-body"></i>
                    <div style=" font-size: 50px" class="bad badge-danger" id="cartCounter">${cartCounter}</div>
                </a>
            </div>
        </div>
    </nav>

</div>



