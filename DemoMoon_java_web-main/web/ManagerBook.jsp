<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 500px;
                height: 500px;
            }
            body{
  background: #1dbf73;
}
        </style>
    <body>
        <c:if test="${not empty requestScope.OK}">
            <script>
                swal("${requestScope.OK}", "You clicked the button!", "success");
            </script>
        </c:if>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Banh</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Banh</span></a>	
                            <a href="MainController?action=home" class="btn btn-success" data-toggle="modal"><span>Back to Home</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.listb}" var="b">
                            <tr>
                                <td>${b.getBanhID()}</td>
                                <td>${b.getBanhName()}</td>
                                <td>
                                    <img src="${b.getImage()}">
                                </td>
                                <td>${b.getPrice()} $</td>
                                <td>${b.isStatus()}</td>
                                <td>
                                    <a href="MainController?action=Update&BID=${b.getBanhID()}"class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a onClick="return a()" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    <form action="MainController" method="POST" style="display: none">
                                        <input type="hidden" name="BID" value="${b.getBanhID()}">
                                        <input type="submit" name="action" id="btndelete" value="Delete">
                                    </form>
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>

                    <script>
                        function a() {
                            swal({
                                title: "Are you sure?",
                                text: "Once deleted, you will not see this in cart!",
                                icon: "warning",
                                buttons: true,
                                dangerMode: true,
                            }).then((willDelete) => {
                                if (willDelete) {
                                    document.getElementById("btndelete").click();
                        <c:if test="${requestScope.OK !=null}">
                                    swal("Poof! Your Banh has been deleted!", {
                                        icon: "success",
                                    });
                        </c:if>
                                } else {
                                    swal("This banh still in your cart!");
                                }
                            });
                        }
                    </script>
                </table>
            </div>
        </div>

        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="MainController" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Add New Banh</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" placeholder="Name of Banh" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="text" placeholder="Link image" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <input name="quantity" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input name="description" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${sessionScope.listc}" var="c">
                                        <option value="${c.getCategoryID()}">${c.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" name="action" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>