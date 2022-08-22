<%-- 
    Document   : foody
    Created on : 25 thg 7, 2022, 18:59:20
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<br><br>
<div class="row">
    <div class="col-md-6">
        <image style="width: 50%; margin-left: 100px" class="card-img-top img-fluid" src="${store.image}"/>
    </div>
    <div class="col-md-6">
        <h1>${store.name}</h1>
        <h3>${store.address}</h3>
        <!--        <div id="map">
                     Maps 
                    
                </div>-->
    </div>
</div>
<br><!-- comment -->


<br>

<br>

<c:forEach items="${store.foodCollection}" var="food">
    <div class="row">
        <div class="col-md-5">           
            <image style="width: 25%; margin-left: 64px" class="card-img-top img-fluid" src="${food.image}"/>            
            <h1>${food.name}</h1>    
        </div>
        <div class="col-md-3">
            <h3 style="margin-top: 20px">${food.price} VND</h3>
        </div>
        <div class="col-md-2" style="margin-top: 20px">
            <a href="#" style="width: 50px" class="btn btn-danger" onclick="addToCart(${food.id}, '${food.name}', ${food.price})" />+</a>
        </div>
    </div>
    <br><!-- comment -->
</c:forEach>
<br><br>



<form>
    <div class="form-group">
        <textarea class="form-control" id="commentId" placeholder="Nhap danh gia .."></textarea>
        <br>
        <input type="button" onclick="addComment(${store.id})"
               value="gui binh luan" class="btn btn-danger" />
    </div>

</form>


<br>
<div id="commentArea">

    <c:forEach items="${commentStore}" var="commentStore">
        <div clas="row">
            <div class="commentDate">
                <p>${commentStore.content}</p>
                <i>${commentStore.createdDate}</i>
                <hr>
            </div>

        </div>
    </c:forEach>

    <nav style="margin-top:20px" aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="1" end="${Math.ceil(commentCounter/2)}" var="i">
                <c:url value="/stores/${store.id}" var="path">
                    <c:param name="page" value="${i}"></c:param>               
                </c:url>
                <li class="page-item"><a class="page-link" href="${path}">${i}</a></li>
                </c:forEach>


        </ul>
    </nav>

    <!--    <div id="map">
             Maps 
    
        </div>-->

    <script >
        window.onload = function () {
            let dates = document.querySelectorAll(".commentDate > i")
            for (let i = 0; i < dates.length; i++)
                dates[i].innerText = moment(dates[i].innerText).fromNow()
        };
       



//        function initMap() {
//            var map = new google.maps.Map(document.getElementById("map"), {
//                center: {lat: 21.0168864, lng: 105.7855574},
//                zoom: 2
//            });
//        }


    </script>

    <!--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADdaCljbArmntPbGxGCes5dt4LFJG7e2Y&callback=initMap" async defer></script>-->


