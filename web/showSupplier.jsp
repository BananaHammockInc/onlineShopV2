<%-- 
    Document   : showSupplier
    Created on : 17-Feb-2015, 10:56:32
    Author     : dex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"</link>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>show all supplier</title>
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
        <div class="container-fluid">
            <ul class="nav nav-pills">
            <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Employees<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="ListEmployee">Show Employees</a></li>
                        <li><a href="createEmployee.jsp">Create Employees</a></li>
                    </ul>
                </li>
            <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Suppliers<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li role="presentation" class=" col-xs-2"><a href="supplierServlet">Show Supplier</a></li>
                        <li role="presentation" class="active col-xs-2"><a href="createSupplier.jsp">Add new supplier</a></li>
                    </ul>
                </li>
                <li role="presentation"class="col-xs-2"><a href="customerServlet">Show Customers</a></li>
                <li role="presentation" class=" pull-right col-xs-2"><a href="shopFront">Back to shop</a></li>
            </ul>
        </div>
        <h1 align="center">Current Suppliers</h1>
        <table align="center" id="supplierTableList" border="3">
            <tr >
                <th bgcolor=>ID</th>
                <th bgcolor=>Business Name</th>
            </tr>
            <c:forEach var="supplierTable" begin="0" items="${requestScope.supplierList}">
                <tr>
                    <td>${supplierTable.SID}&nbsp;&nbsp;</td>
                    <td>${supplierTable.businessName}&nbsp;&nbsp;</td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>
