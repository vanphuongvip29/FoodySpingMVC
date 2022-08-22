<%-- 
    Document   : base-admin
    Created on : 13 thg 8, 2022, 11:17:54
    Author     : tran van phuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>



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
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        
        <script src="<c:url value="/resources/js/stats.js" />"/></script>
        
        
       

    </head>

    <body>
        <h1 class="text-center text-info">THỐNG KÊ - BÁO CÁO</h1>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-xs-12 bg-light">
                    <tiles:insertAttribute name="left" />
                </div>
                <div class="col-md-8 col-xs-12">
                    <tiles:insertAttribute name="content" /> 
                </div>
            </div>
            
            
            <tiles:insertAttribute name="footer" />
        </div>

       
    </body>
</html>
