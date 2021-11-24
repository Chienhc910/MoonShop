<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/css.css">
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id" content="542273842720-sjjmduo4sf62gs9h2uj565ml101sg7v5.apps.googleusercontent.com">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <style>
            body{
  background: #1dbf73;
}
        </style>
        <c:if test="${not empty requestScope.OUT}">
            <script>
                swal("${requestScope.OUT}", "You clicked the button!", "success");
            </script>
        </c:if>
        <div class="wrapper">
            <div class="form">
                <div class="title">
                    Login
                </div>
                <form method="post" action="MainController">
                    <div class="input_wrap">
                        <label for="input_text">Username:</label>
                        <div class="input_field">
                              <input type="text" name="username" class="input" id="input_text">
                        </div>
                    </div>
                    <div class="input_wrap">
                        <label for="input_password">Password:</label>
                        <div class="input_field">
                             <input type="password" name="password" class="input" id="input_password">
                        </div>
                    </div>
                    
                    
                    
                    <c:if test="${requestScope.MESS !=null}">
                        <font color="red">
                        Incorrect username or password. Please try again!!
                        </font>
                        </c:if>
                    <div class="input_wrap">
                        <input type="submit" name="action" id="login_btn" class="btn disabled" value="Login" disabled="true">
                    </div>
                </form>

                
            </div>
        </div>
    </body>
    <script>
        var input_fields = document.querySelectorAll(".input");
        var login_btn = document.querySelector("#login_btn");

        input_fields.forEach(function (input_item) {
            input_item.addEventListener("input", function () {
                if (input_item.value.length > 3) {
                    login_btn.disabled = false;
                    login_btn.className = "btn enabled"
                }
            })
        });

    </script>


</html>

