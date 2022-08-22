<%-- 
    Document   : base
    Created on : 19 thg 7, 2022, 21:20:53
    Author     : tran van phuong
--%>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>

        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
        <script src="<c:url value="/resources/js/main.js" />"/></script>

        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script scr="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
        
        
       

    </head>

    <body>
        <tiles:insertAttribute name="header" />

        <div class="container">
            <tiles:insertAttribute name="content" />
        </div>

        <tiles:insertAttribute name="footer" />
    </body>
</html>
