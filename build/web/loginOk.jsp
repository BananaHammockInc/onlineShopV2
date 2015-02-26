<%-- 
    Document   : loginOk
    Created on : 10-Feb-2015, 12:08:09
    Author     : dex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"</link>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success!</title>
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

            .p {
                text-align: justify;
                
            }
            .move-right{
                display: block;
                float: right;
            }
        </style>
    </head>
    <body>
        
        <%
            String email = null;
            String admin = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("email")) {
                        email = cookie.getValue();
                    } else if (cookie.getName().equals("admin")) {
                        admin = cookie.getValue();
                    }
                }
            }
            if (email == null && admin == null) {
                response.sendRedirect("shopFront");
            }
        %>
        <div class="navbar navbar-default">
           <h1 align='center'>Banana Hammock!</h1>
           <h3 align="right">You are now logged in as: <%=email %></h3>
        </div>
        <div class="container">
            <ul class="nav nav-pills">
                <li role="presentation" class=" col-xs-4"><a href="shopFront">Shop</a></li>
            </ul>
        </div>
        
           <p align="center"> What do you wish to do now?</p>
           <div class="wide">
           <div class="btn-group-vertical col-md-6 move-right" role="group" aria-label="false">
                 <button type="button" class="btn btn-deault"><a href="createEmployee.jsp"> Create new employee </a></button>
                 <button type="button" class="btn btn-deault"><a href="ListEmployee"> Show Employees </a></button>
                 <button type="button" class="btn btn-deault"><a href="customerServlet"> Show Customers </a></button>
                 <button type="button" class="btn btn-deault"><a href="createSupplier.jsp"> Create new supplier</a></button>
                 <button type="button" class="btn btn-deault"><a href="supplierServlet"> Show Suppliers </a></button>
                 <button type="button" class="btn btn-deault"><a href="addNewProduct"> Add new product</a></button>
                 <button type="button" class="btn btn-deault"><a href="productServlet"> Show products</a></button>
                 <button type="button" class="btn btn-deault"><a href="updateStockLevelServlet"> Update stock Level</a></button>
                 <button type="button" class="btn btn-deault"><a href="updateCustomerDetails"> Update customer details</a></button>
                 <button type="button" class="btn btn-deault"><a href="index.jsp"> Logout</a></button>
                 
               </div>
            </div>
    </body>
</html>
