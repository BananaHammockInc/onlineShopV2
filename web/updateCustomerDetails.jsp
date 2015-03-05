<%-- 
    Document   : updateCustomerDetails
    Created on : 24-Feb-2015, 11:06:51
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
        <title>Details</title>
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
                max-width: 500px;
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
       <h2 align="center">Here you can change customer details</h2>
       
        <script type="text/javascript">
            var customers = new Array();
            <c:forEach var="customerTable" begin="0" items="${requestScope.customerList}">
            customers[${customerTable.CID}] = new Array();
            customers[${customerTable.CID}].fName = "${customerTable.FName}";
            customers[${customerTable.CID}].sName = "${customerTable.SName}";
            customers[${customerTable.CID}].email = "${customerTable.email}";
            customers[${customerTable.CID}].AddrLine1 = "${customerTable.addressLine1}";
            customers[${customerTable.CID}].AddrLine2 = "${customerTable.addressLine2}";
            customers[${customerTable.CID}].city = "${customerTable.city}";
            customers[${customerTable.CID}].creditCard = ${customerTable.cardNumber};
            </c:forEach>
        </script>
        <form id="customerUpdateForm" action="updateCustomer" name="customerUpdateForm" method="post" align="center">
   <div class="wide col-md-4">
            <table id="customerUpdateTable" class="table pull-right">
                
                <tr>
                    <td>
                        <select id="customerEmail" name="customerEmail">
                            <option value="" selected></option>
                            <c:forEach var="customerTable" begin="0" items="${requestScope.customerList}">
                                <option value=${customerTable.CID}>${customerTable.email}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr><td>First Name:</td><td><input type="text" value="" id="populatemeFName" name="populatemeFName"/></td></tr>
                <tr><td>Surname:</td><td><input type="text" value="" id="populatemeSName" name="populatemeSName"/></td></tr>
                <tr><td>Email:</td><td><input type="text" value="" id="populatemeEmail" name="populatemeEmail"/></td></tr>
                <tr><td>Address Line 1:</td><td><input type="text" value="" id="populatemeAddrLine1" name="populatemeAddrLine1"/></td></tr>
                <tr><td>Address Line 2:</td><td><input type="text" value="" id="populatemeAddrLine2" name="populatemeAddrLine2"/></td></tr>
                <tr><td>City:</td><td><input type="text" value="" id="populatemeCity" name="populatemeCity"/></td></tr>
                <tr><td>Credit Card Number:</td><td><input type="text" value="" id="populatemeCreditCard" name="populatemeCreditCard"/></td></tr>
            </table> 
</div>
            <button class="btn btn-success" type="submit" id="updateCustomer">Change</button>
            <button class="btn btn-danger" href="loginOk.jsp">Cancel</button>
        </form>
        <a href="loginOk.jsp"> go back</a>
        <script type="text/javascript">
            document.customerUpdateForm.customerEmail.onchange = updateText;
            function updateText() {
                var obj_sel = document.customerUpdateForm.customerEmail;
                document.customerUpdateForm.populatemeFName.value = customers[obj_sel.value].fName;
                document.customerUpdateForm.populatemeSName.value = customers[obj_sel.value].sName;
                document.customerUpdateForm.populatemeEmail.value = customers[obj_sel.value].email;
                document.customerUpdateForm.populatemeAddrLine1.value = customers[obj_sel.value].AddrLine1;
                document.customerUpdateForm.populatemeAddrLine2.value = customers[obj_sel.value].AddrLine2;
                document.customerUpdateForm.populatemeCity.value = customers[obj_sel.value].city;
                document.customerUpdateForm.populatemeCreditCard.value = customers[obj_sel.value].creditCard;
            }
        </script>
    </body>
</html>
