<%-- 
    Document   : loginFail
    Created on : 10-Feb-2015, 12:08:20
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"</link>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
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
             #wrapper {
                    border: 1px #e4e4e4 solid;
            }
        </style>
    </head>
    <body id="wrapper" class="container">
        <div class="navbar navbar-default">
           <h1 align='center'>Banana Hammock!</h1>
           <div class="container">
            <ul class="nav nav-pills">
                <li role="presentation"><a href="shopFront">Shop</a></li>
                <li role="presentation"><a href="login.jsp"> Log in!</a></li>
            </ul>
        </div>
        </div>
        <div class="panel panel-danger">
        <div class="panel-heading">Oops....</div>
        <div class="panel-body">Your log in information does not seem to be correct. Either try again or create an account</div>
    </body>
</html>
