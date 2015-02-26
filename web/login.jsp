<%-- 
    Document   : login
    Created on : 10-Feb-2015, 11:14:33
    Author     : dex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"</link>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .jumbotron {
                height: 100px;
            }
            .wide {
                width: 50%;
                height: 500px;
                background-image: url('http://www.wpclipart.com/food/fruit/banana/banana_peeled.png');
                background-repeat: no-repeat;
                background-origin: content-box;
           
            }
            .wide img {
                width: 50%;
            }
            
            .form {
                height: 200px;
                width: 200px;
                padding-right: 20px;
            }
            .p {
                text-align: justify;
            }
        </style>
    </head>
    <body>
        <div class="navbar navbar-default">
           <h1 align='center'>Banana Hammock!</h1>
        </div>
        <div class="container">
            <ul class="nav nav-pills">
                <li role="presentation" class=" col-xs-4"><a href="shopFront">Shop</a></li>
                <li role="presentation"class="active col-xs-4"><a href="createCustomer.jsp"> Sign up!</a></li>
            </ul>
        </div>
        <p><form class="col-md-10" align="center" id="loginForm" action="loginServlet" method="post">
        <table align="center">
            <div class='wide col-md-6'>
            <tr><td>Email:</td><td><input type="text" id="FName" name="Email"/></td></tr>
            <tr><td>Password:</td><td><input type="password" id="UserPassword" name="UserPassword"/></td></tr>
            </div>
        </table>
            <input type="submit" id="login" value="Login"/><br>
            <p><a href="tooBad.jsp"> Forgot your password? </a></p>
        </form></p>
    </body>
</html>
