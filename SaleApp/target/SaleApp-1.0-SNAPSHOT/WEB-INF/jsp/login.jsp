<%-- 
    Document   : login
    Created on : 25 thg 7, 2022, 18:55:15
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/login" var="action"/>



<h1 class="text-center text-danger">ĐĂNG NHẬP</h1>

<c:if test="${param.error !=null}">
    <div class="alert alert-danger">
        Da co loi xay ra! Vui Long Thu Lai!
    </div>
    
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Ban khong co quyen
    </div>
    
</c:if>

<form style="margin-top:50px" method="post" action="${action}">
    <div style="margin-top:20px" class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>    
    </div>
    <div style="margin-top:20px" class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control"/>    
    </div>
    <div style="margin-top:20px" class="form-group">
        <input type="submit" value="DANG NHAP" class="btn btn-primary" />
    </div>
</form>
