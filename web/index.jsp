<%-- 
    Document   : index
    Created on : 09-Feb-2015, 18:55:11
    Author     : dex
/**
 * 
 * Aaron Kelly - 12350566
 * Alex McElhinney - 12437802
 * Evan Preisler - 10101753
 * CT338 - Software Engineering Project: Banana Hammock, Online Fruit & Veg Store
 * 2015
 * 
 *
 * @author dex
 */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"></link>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .wide {
                width: 100%;
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
            
            #wrapper {
                    border: 1px #e4e4e4 solid;
            }
            
            .float{
                float: right;
            }

        </style>
    </head>
    <body id="wrapper" class="container">
        <div class="navbar navbar-default">
           <h1 align='center'>Banana Hammock!</h1>
             <div class="container">
            <ul class="nav nav-pills">
                <li role="presentation" class=" col-xs-2"><a href="shopFront">Shop</a></li>
                <li role="presentation" class="active col-xs-2 pull-right"><a href="createCustomer.jsp"> Sign up!</a></li>
            </ul>
        </div>
        </div>
        <div class="wide col-md-12 center">
             <p><form class="col-md-10 float" align="center" id="loginForm" action="loginServlet" method="post">
             <table align="center">
              <tr><td>Email:</td><td><input type="text" id="FName" name="Email"/></td></tr>
              <tr><td>Password:</td><td><input type="password" id="UserPassword" name="UserPassword"/></td></tr>
             </table>
                 <button type="submit" class="btn-primary" id="login"> Log in</button>
                 <p><a href="tooBad.jsp"> Forgot your password? </a></p>
        </form></p>
        </div>   
    </body>
</html>
