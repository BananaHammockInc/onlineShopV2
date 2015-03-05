<%-- 
    Document   : showEmployee
    Created on : 04-Feb-2015, 10:28:41
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
        <title>show all employees</title>
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
                border: 0px;
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
                    </ul>
                </li>
                
                <li role="presentation" class=" pull-right col-xs-2"><a href="shopFront">Back to shop</a></li>
            </ul>
        </div>
        </div>
       <div class="panel panel-info">
           <div class="panel-heading"> Here are your current employees</div>
           <div class="panel-body"><p>If you wish to add any more employees please refer to the top bar. :)</p></div>
        <table align="center" id="EmployeeTableList" class="table">
            <tr >
                <th bgcolor=>ID</th>
                <th bgcolor=>First Name</th>
                <th bgcolor=>Surname</th>
                <th bgcolor=>Email</th>
                <th bgcolor=>Address Line 1</th>
                <th bgcolor=>Address Line 2</th>
                <th bgcolor=>City</th>
                <th bgcolor=>Contact Number</th>
                <th bgcolor=>Role In Company</th>
                <th bgcolor=>Salary</th>
            </tr>
            <c:forEach var="employee" begin="0" items="${requestScope.employeeList}">
                <tr>
                    <td>${employee.pkID}&nbsp;&nbsp;</td>
                    <td>${employee.FName}&nbsp;&nbsp;</td>
                    <td>${employee.SName}&nbsp;&nbsp;</td>
                    <td>${employee.email}&nbsp;&nbsp;</td>
                    <td>${employee.addressLine1}&nbsp;&nbsp;</td>
                    <td>${employee.addressLine2}&nbsp;&nbsp;</td>
                    <td>${employee.city}&nbsp;&nbsp;</td>
                    <td>${employee.contactNumber}&nbsp;&nbsp;</td>
                    <td>${employee.roleInCompany}&nbsp;&nbsp;</td>
                    <td>${employee.salary}&nbsp;&nbsp;</td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>
