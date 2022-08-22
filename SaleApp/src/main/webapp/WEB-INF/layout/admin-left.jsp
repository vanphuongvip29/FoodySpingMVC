<%-- 
    Document   : admin-left
    Created on : 13 thg 8, 2022, 11:24:31
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar bg-light">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/category-stats"/>">Thong ke doanh thu theo san pham</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/store-stats"/>">Thong ke doanh thu cua hang</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/store-month-stats"/>">Thong ke doanh thu theo thang</a>
      </li>
      
    </ul>
  </div>
</nav>
