<%-- 
    Document   : store-stats
    Created on : 13 thg 8, 2022, 11:27:59
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Thong ke san pham theo danh muc</h1>

<div>
    <canvas id="myCateStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã danh mục</th>
        <th>Tên danh mục</th>
        <th>Số lượng cửa hàng</th>
    </tr>
    <c:forEach items="${cateStats}" var="s">
        <tr>
            <th>${s[0]}</th>
            <th>${s[1]}</th>
            <th>${s[2]}</th>
        </tr>

    </c:forEach>
</table>

<script>
    window.onload = function () {
        let data = [];
        let labels = [];

    <c:forEach items="${cateStats}" var="c">
        data.push(${c[2]});
        labels.push('${c[1]}');
    </c:forEach>

    cateChart(labels, data);

    }
</script>