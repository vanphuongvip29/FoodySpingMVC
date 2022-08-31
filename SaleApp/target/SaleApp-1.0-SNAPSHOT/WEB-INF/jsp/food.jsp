<%-- 
    Document   : Food
    Created on : Aug 30, 2022, 10:35:21 AM
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1 class="text-center">THEM MON AN</h1>


<c:url value="/store/registerFood/${store.id}" var="action"></c:url>

<form:form method="post"
           action="${action}"         
           modelAttribute="food"
           enctype="multipart/form-data">
    <div class="mb-3 mt-3">
        <label for="name">Ten Mon An</label>
        <form:input type="text" id="name" path="name" cssClass="form-control" />
    </div>
    <div class="mb-3">
        <label for="price">Gia</label>
        <form:input type="text" id="price" path="price" cssClass="form-control" />
    </div>
    <div class="mb-3">
        <label for="file">Anh Mon An</label>
        <form:input type="file" id="file" path="file" cssClass="form-control" />
    </div>

    <div class="form-group" >
        <input type="submit" value="Them Mon An" class="btn btn-primary" />
    </div>
</form:form>
