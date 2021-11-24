<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-light">
     <div class="container">
        <a class="navbar-brand text-uppercase" href="MainController?action=home"> BOOK STORE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <form action="MainController" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${param.search}" name="search" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" name="action" value="Search" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <c:if test="${sessionScope.USER.getRoleID() == 2}">
                <a class="btn btn-success btn-sm ml-3" href="MainController?action=showcart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">${sessionScope.CART.size()}</span>
                </a>
                </c:if>
            </form>
            <ul class="navbar-nav badge-light">
                <c:if test="${sessionScope.USER.getRoleID() == 1}">
                    <li class="nav-item">
                             <a class="nav-item text-uppercase" href="MainController?action=manager">Manager Banh</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.USER != null}">
                  
                    <li class="nav-item">
                            <a class="nav-link text-uppercase" href="MainController?action=History">History Order</a>
                    </li>
                    <li  class="nav-item">
                        <a></a>
                    </li>
                    <li class="nav-item">
                            <a class="nav-link text-uppercase" href="MainController?action=Logout"> Logout</a>
                    </li> 
                </c:if>
            </ul>
            
        </div>
    </div>
</nav>
<section class="">
    <div class="container">
        <h1 class="jumbotron-heading">    
        </h1>
        <p class="lead text-muted mb-0">  
        </p>
    </div>
</section>

