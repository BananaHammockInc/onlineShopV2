<%-- 
    Document   : showAllOrders
    Created on : 02-Mar-2015, 14:33:28
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
        <title>Orders</title>
        <style>
            .jumbotron {
                height: 100px;
            }
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

            .p {
                text-align: justify;
                
            }
            .move-right{
                display: block;
                float: right;
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
           <h1 align='center'>Banana Hammock!</h1>
           <div class="container">
            <ul class="nav nav-pills">
                <li role="presentation" class=" col-xs-2"><a href="supplierLogin.jsp">Main</a></li>
                <li role="presentation" class="col-xs-2 pull-right"><a href="index.jsp">Log Out</a></li>
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
              
        </div>
        </div>
        <h1 align="center">Your current orders:</h1>
        <table align="center" id="allCustomerPurchasesTable" class="table">
            <tr>
                <th bgcolor=>Invoice ID</th>
                <th bgcolor=>Date</th>
                <th bgcolor=>Total Added</th>
                <th bgcolor=>Pick</th>
            </tr>
            <c:forEach var="orders" begin="0" items="${requestScope.allOrder.invoice}">
                <tr>
                    <td>${orders.inID}</td>
                    <td>${orders.date}</td>
                    <td>${orders.totalAdded}</td>
                    <td>
                        <form action="getContent" method="post">
                            <input type="hidden" name="invoiceID" value="${orders.inID}"/>
                            <input type="submit" name="submit" value="Check Invoice">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="supplierLogin.jsp"> go back</a>
    </body>
</html>
