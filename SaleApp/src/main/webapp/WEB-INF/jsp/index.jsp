<%--
    Document   : index
    Created on : 21 thg 7, 2022, 20:21:24
    Author     : tran van phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Product Start -->



<div class="container-xxl py-5">
    <div class="container">
        <nav style="margin-top:20px" aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="1" end="${Math.ceil(storeCounter/9)}" var="page">
                    <li class="page-item"><a class="page-link" href="<c:url value="/"/>?page${page}">${page}</a></li>
                    </c:forEach>


            </ul>
        </nav>
        <div class="col-lg-6 text-start text-lg-end wow slideInRight" data-wow-delay="0.1s">
            <ul class="nav nav-pills d-inline-flex justify-content-end mb-5">
                <c:forEach var="c" items="${categories}">
                    <li class="nav-item me-2">
                        <c:url value="/" var="catPath">
                            <c:param name="CateId" value="${c.id}"></c:param>
                        </c:url>
                        <a class="btn btn-outline-primary border-2" data-bs-toggle="pill" href="${catPath}">${c.name} </a>
                    </li>
                </c:forEach>
            </ul>
            <ul class="nav nav-pills d-inline-flex justify-content-end mb-5">
                <form class="d-flex" action="<c:url value="/" />">
                    <input class="form-control me-2" name="kw" type="text" placeholder="Search">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
            </ul>
        </div>



        <div class="tab-content">
            <div id="tab-1" class="tab-pane fade show p-0 active">
                <div class="row g-4">
                    <c:forEach var="s" items="${stores}">
                        <div class="col-xl-3 col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                            <c:url value="/" var="storePath">
                                <c:param name="StoreId" value="${s.id}"></c:param>
                            </c:url>
                            <div class="product-item">
                                <div class="position-relative bg-light overflow-hidden">
                                    <img class="img-fluid w-100" src="${s.image}" alt="">
                                    <div class="bg-secondary rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">New</div>
                                </div>
                                <div class="text-center p-4">
                                    <a class="d-block h5 mb-2" href="">${s.name}</a>
                                    <span class="text-primary me-1">${s.address}</span>

                                </div>
                                <div class="d-flex border-top">
                                    <small class="w-50 text-center border-end py-2">
                                      
                                        <a class="text-body" href="<c:url value="/stores/${s.id}" />"><i class="fa fa-eye text-primary me-2"></i>View detail</a>
                                    </small>
                                    <small class="w-50 text-center py-2">
                                        <a class="text-body" href=""><i class="fa fa-shopping-bag text-primary me-2"></i>Follow</a>
                                    </small>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
</div>
<!-- Product End -->

