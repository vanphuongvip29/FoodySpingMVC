<%-- 
    Document   : cart
    Created on : 12 thg 8, 2022, 19:50:02
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">GIỎ HÀNG</h1>

<c:if test="${carts == null}">
    <h4 class="text-center text-danger">Khong co san pham</h4>
</c:if>
    
<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Ma san pham</th>
            <th>Ten san pham</th>
            <th>Don gia</th>
            <th>So luong</th>
            <th></th>
        </tr>
        <c:forEach items="${carts}" var="c">
        <tr>
            <td>${c.foodId}</td>
            <td>${c.foodName}</td>
            <td>${c.price} VND</td>
            <td>
                <div class="form-group">
                    <input type="number"
                           onblur="updateCart(this,${c.foodId})"
                           value="${c.quantity}" 
                           class="form-control" />
                </div>
            </td>
            <td>
                <input type="button"
                       value="Xoa" 
                       onclick="deleteCart(${c.foodId})"
                       class="btn btn-danger"/>
            </td>
        </tr>
        </c:forEach>
    </table>
    <div>
        <h4 class="text-info">Tong tien:    <span id="amountCart">${cartStats.amount}</span> VND</h4>
    </div>
        <input onclick="pay()" type="button" value="THANH TOAN" class="btn btn-danger"/>
</c:if>