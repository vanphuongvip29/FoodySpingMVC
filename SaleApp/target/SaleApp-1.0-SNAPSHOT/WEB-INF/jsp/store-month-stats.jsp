<%-- 
    Document   : store-month-stats
    Created on : Aug 19, 2022, 8:24:23 PM
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>THONG KE DOANH THU THEO THANG</h1>

<div>
    <canvas id="myCateStatsChart3"></canvas>
</div>
<table class="table">
    <tr>
        <th>Thang</th>              
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${storeMonthStats}" var="s">
        <tr>
            <th>${s[0]}/${s[1]}</th>
            
            <th>${s[2]} VND</th>
            
        </tr>

    </c:forEach>
</table>


<script>
    window.onload = function () {
        let data3 = [];
        let labels3 = [];

    <c:forEach items="${storeMonthStats}" var="s">
        data3.push(${s[2]});
        labels3.push('${s[0]}/${s[1]}');
    </c:forEach>

    storeMonthChart(labels3, data3);

    }
</script>