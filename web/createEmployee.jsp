<%-- 
    Document   : createEmployee
    Created on : 04-Feb-2015, 10:29:20
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
        <title>Creating a new employee entry</title>
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
            
            .table{
                max-width: 400px;
            }
        </style>
    </head>
    <body id="wrapper" class="container">
         <div class="navbar navbar-default">
           <h1 align='center'>Banana Hammock!</h1>
           <div class="container">
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
                        <li role="presentation"><a href="supplierServlet">Show Supplier</a></li>
                        <li role="presentation"><a href="createSupplier.jsp">Add new supplier</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Customers<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                       <li role="presentation"><a href="customerServlet">Show Customers</a></li>
                       <li role="presentation"><a href="updateCustomerDetails.jsp">Change details</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Stock<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                       <li role="presentation"><a href="showProduct.jsp">Show stock</a></li>
                       <li role="presentation"><a href="updateStockLevel.jsp">Update Stock</a></li>
                       <li role="presentation"><a href="createProduct.jsp">Add new product</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">History<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                       <li role="presentation"><a href="showAllPurchase.jsp">Show all purchases</a></li>
                       
                    </ul>
                </li>
                
                <li role="presentation" class=" pull-right col-xs-2"><a href="shopFront">Back to shop</a></li>
            </ul>
        </div>
        </div>
        <h2 align="center">Create your new Banana Hammock employee here!</h2>
        <form id="createEmployeeForm" action="employeeServletPage" method="post">
        <table class="table">
            <div class="wide col-md-6">
            <tr><td>First Name:</td><td><input type="text" id="FName" name="FName"/></td></tr>
            <tr><td>Surname:</td><td><input type="text" id="SName" name="SName"/></td></tr>
            <tr><td>Email:</td><td><input type="text" id="AddressLine1" name="Email"/></td></tr>
            <tr><td>Address Line 1:</td><td><input type="text" id="AddressLine1" name="AddressLine1"/></td></tr>
            <tr><td>Address Line 2:</td><td><input type="text" id="AddressLine2" name="AddressLine2"/></td></tr>
            <tr><td>City:</td><td><input type="text" id="CityName" name="CityName"/></td></tr>
            <tr><td>Password:</td><td><input type="password" id="UserPassword" name="UserPassword"/></td></tr>
            <tr><td>Contact Number:</td><td><input type="text" id="ContactNum" name="ContactNum"/></td></tr>
            <tr><td>Role in Company:</td><td><input type="text" id="RoleInCompany" name="RoleInCompany"/></td></tr>
            <tr><td>Salary:</td><td><input type="number" id="Salary" name="Salary"/></td></tr>
            </div>
        </table>
            <button class="btn btn-primary" type="submit" id="createEmployee"> Add new employee</button>
            
        </form>
        <a href="loginOk.jsp">Go Back</a>
    </body>
</html>