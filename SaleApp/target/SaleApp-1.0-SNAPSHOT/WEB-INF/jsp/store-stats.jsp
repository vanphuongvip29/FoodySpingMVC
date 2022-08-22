<%-- 
    Document   : store-stats
    Created on : Aug 18, 2022, 8:00:46 PM
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>THONG KE DOANH THU THEO CUA HANG</h1>

<form action="">
    
    <div class="form-group">
        <label>Tu Thoi Diem</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Den Thoi Diem</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success"/>
</form>

<div>
    <canvas id="myCateStatsChart2"></canvas>
</div>
<table class="table">
    <tr>
        <th>Mã cua hang</th>
        <th>Tên cua hang</th>
        
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${storeStats}" var="s">
        <tr>
            <th>${s[0]}</th>
            <th>${s[1]}</th>
            <th>${s[2]} VND</th>
            
        </tr>

    </c:forEach>
</table>

<script>
    window.onload = function () {
        let data2 = [];
        let labels2 = [];

    <c:forEach items="${storeStats}" var="s">
        data2.push(${s[2]});
        labels2.push('${s[1]}');
    </c:forEach>

    storeChart(labels2, data2);

    }
</script>
