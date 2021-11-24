<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        
body{
  background: #1dbf73;
}

    </style>
    <body>
        <font color="blue">
        Welcome, ${sessionScope.USERNAME}
        </font><br/>

        <c:if test="${not empty requestScope.OUT}">
            <script>
                swal("SORRY!", "${requestScope.OUT}");
            </script>
        </c:if>
        <c:if test="${not empty requestScope.OK}">
            <script>
                swal("${requestScope.OK}", "You clicked the button!", "success");
            </script>
        </c:if>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb d-flex justify-content-center">

                                <form action="MainController" class="d-flex align-items-center" >

                                  <li > <input class="form-control " type="number" name="number1" value="${param.number1}$"  ></li>
                                <li>to</li>
                                <li class="mx-2" > <input class="form-control" type="number" name="number2" value="${param.number2}$"  ></li>
                                <li> <input class="btn btn-secondary" type="submit" name="action" value="Search By Money"></li>
                            </form>
                                <a>        <style>
                                                 .carousel-inner {
                                                    position: relative;
                                                     width: 100%;
                                                     overflow: hidden;
                                                   }
                                                .carousel-inner::after {
                                                 display: block;
                                                 clear: both;
                                                content: "";
}

            </style>
                                         <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                      <img class="d-block img-fluid" src="https://scontent.fdad2-1.fna.fbcdn.net/v/t1.0-9/147429580_746010902718915_161400099841107660_o.jpg?_nc_cat=101&ccb=3&_nc_sid=e3f864&_nc_ohc=zgJ1BGLrZOQAX_ItbzT&_nc_ht=scontent.fdad2-1.fna&oh=91565c086e70ad9b32f0fee69213a74d&oe=6057EB2C" alt="First slide">

                            </div>
                            <div class="carousel-item ">
                                <img class="d-block img-fluid" src="https://scontent-hkg4-2.xx.fbcdn.net/v/t1.0-9/30705085_182677042385640_8285350569523019776_o.png?_nc_cat=110&ccb=3&_nc_sid=e3f864&_nc_ohc=9n_2eTFDHZMAX-83U4d&_nc_ht=scontent-hkg4-2.xx&oh=8499dfef3338f4dfe516aed9f24659cf&oe=60560482" alt="Second slide">

                            </div>
                            <div class="carousel-item ">
                                <img class="d-block img-fluid" src="https://scontent.fdad2-1.fna.fbcdn.net/v/t1.0-9/147429580_746010902718915_161400099841107660_o.jpg?_nc_cat=101&ccb=3&_nc_sid=e3f864&_nc_ohc=zgJ1BGLrZOQAX_ItbzT&_nc_ht=scontent.fdad2-1.fna&oh=91565c086e70ad9b32f0fee69213a74d&oe=6057EB2C" alt="First slide">

                            </div>
                        </div>
                                </a>
                            </div>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="col-sm-9">
                        <div id="content" class="row">

                            
                        <c:forEach items="${sessionScope.listb}" var="b">
                            <c:if test="${b.isStatus()}"> 
                                <div class="product col-12 col-md-6 col-lg-4">
                                    <div class="card">
                                        <img class="card-img-top" src="${b.getImage()}" alt="Card image cap">
                                        <div class="card-body">
                                            <h4 class="card-title show_txt"><a href="detail?bid=${b.getBanhID()}" title="View Banh"></a></h4>
                                            <p class="card-text show_txt">${b.getBanhName()}</p>
                                            <div class="row">
                                                <div class="col">
                                                    <p class="btn btn-danger btn-block">${b.getPrice()} $</p>
                                                </div>
                                                <c:if test="${sessionScope.USER.getRoleID() == 2}">
                                                    <c:if test="${b.getQuantity()>0}">
                                                        <div class="col">
                                                            <a href="MainController?action=AddtoCart&BID=${b.getBanhID()}" class="btn btn-success btn-block">Add to cart</a>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${b.getQuantity()<=0}">
                                                        <p class="card-text show_txt" style="text-align: center">Out Of Quantity</p>
                                                    </c:if>
                                                </c:if>
                                                        
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                        <c:if test="${empty sessionScope.listb}"><h1 class="jumbotron-heading">Sorry! Out of quantity</h1></c:if>
                    </div>
                </div>

            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>

