<%-- 
    Document   : register-food
    Created on : 10 thg 8, 2022, 21:00:44
    Author     : tran van phuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center">ĐĂNG KÝ MÓN ĂN</h1>


<br><br>



<h1>${user.storeCollection}</h1>
<h1>${user.id}</h1>
<h1>${user.username}</h1>



<c:forEach items="${user.storeCollection}" var="storeUser">
    <div class="row">
        <div class="col-md-6">
            <image style="width: 50%; margin-left: 100px" class="card-img-top img-fluid" src="${storeUser.image}"/>
        </div>
        <div class="col-md-6">
            <h1>${storeUser.name}</h1>
            <h3>${storeUser.address}</h3>
        </div>
    </div>
</c:forEach>

<div class="row">
    <div class="col-md-6">
        <image style="width: 50%; margin-left: 100px" class="card-img-top img-fluid" src="${store.image}"/>
    </div>
    <div class="col-md-6">
        <h1>${store.name}</h1>
        <h3>${store.address}</h3>
    </div>
</div>