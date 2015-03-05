<%-- 
    Document   : createOrder
    Created on : 02-Mar-2015, 22:38:41
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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"></link>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create order</title>
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
            
            .table{
                max-width: 500px;
            }
        </style>
    </head>
    <body id="wrapper" class="container">
        <div class="navbar navbar-default">
            <h1 align="center">Banana Hammock</h1>
            <div class="container-fluid">
                <ul class="nav nav-pills" align="center">
                    <li role="presentation" align="center" class="pull-right"><a href="index.jsp"> Logout </a><br></li>
                    <li role="presentation"><a href="supplierLogin.jsp">Main</a></li>
                    <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Your products<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="addNewProduct">Add new stock</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Your orders<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="createOrder">Add new order</a></li>
                        <li><a href="viewOrder">View orders</a></li>
                    </ul>
                </li>
                    
                </ul>
            </div>
        </div>
        <h2 align="center">Add a new order here</h2>
        <table id="productTableList" class="table" align="center">
            <tr>
                <th bgcolor=>Product name</th>
                <th bgcolor=>Amount to be added</th>
            </tr>
        <c:forEach var="product" begin="0" items="${requestScope.product}">
            <tr>
                <td>${product.productName}</td>
                <td>
                    <form action="updateOrder" method="post">
                        <input type="hidden" name="productID" value=${product.PID}>
                        <input type="text" name="quantity" value="0">
                        <input type="submit" name="submit" value="Add to Order">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </table>
        <form action="checkOrder" method="post">
            <button class="btn btn-info" type="submit" name="submit">Review order</button>
        </form>
        <a href="supplierLogin.jsp">back</a>
    </body>
</html>
