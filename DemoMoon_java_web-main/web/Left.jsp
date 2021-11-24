<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-success mb-3">

        <ul class="list-group category_block">
            <c:forEach items="${sessionScope.listc}" var="c">
                <li class="list-group-item text-muted "><a href="MainController?action=category&cid=${c.getCategoryID()}">${c.getCategoryName()}</a></li>
                </c:forEach>
                <li class="list-group-item text-muted "><a href="MainController?action=category&cid=0">List All</a></li>
        </ul>
        
    </div>
</div>