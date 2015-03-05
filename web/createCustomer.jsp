<%-- 
    Document   : createCustomer
    Created on : 17-Feb-2015, 09:43:54
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
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"></link>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome new user</title>
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
        
        <h1 align="center">Please enter you details below</h1>
        <form id="createCustomerForm" action="newCustomerServlet" method="post">
        <table>
            <div class="wide col-md-6"
            <tr><td>First Name:</td><td><input type="text" id="FName" name="FName"/></td></tr>
            <tr><td>Surname:</td><td><input type="text" id="SName" name="SName"/></td></tr>
            <tr><td>Email:</td><td><input type="text" id="AddressLine1" name="Email"/></td></tr>
            <tr><td>Address Line 1:</td><td><input type="text" id="AddressLine1" name="AddressLine1"/></td></tr>
            <tr><td>Address Line 2:</td><td><input type="text" id="AddressLine2" name="AddressLine2"/></td></tr>
            <tr><td>City:</td><td><input type="text" id="CityName" name="CityName"/></td></tr>
            <tr><td>Password:</td><td><input type="password" id="UserPassword" name="UserPassword"/></td></tr>
            <tr><td>Credit Card Number:</td><td><input type="number" id="Salary" name="CreditCard"/></td></tr>
            </div>
        </table>
            <p><button class="btn btn-primary" type="submit" id="createCustomer">Create new account</button></p>
        </form>
        <a href="index.jsp">Cancel</a>
        <p>Clean and simple, ammiright? Thank you!</p>
    </body>
</html>