<%-- 
    Document   : updateStockLevel
    Created on : 23-Feb-2015, 15:17:49
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
        <title>Update Stock Levels</title>
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
                       <li role="presentation"><a href="showAllPurchase.jsp">Purchase History</a></li>
                       <li role="presentation"><a href="showCustomerReceiptResults.jsp">Previous Receipts</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Stock<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                       <li role="presentation"><a href="productServlet">Show stock</a></li>
                       <li role="presentation"><a href="updateStockLevel.jsp">Update Stock</a></li>
                    </ul>
                </li>
                
                <li role="presentation" class=" pull-right col-xs-2"><a href="shopFront">Back to shop</a></li>
            </ul>
        </div>
        </div>
    </head>
    <body>
        <h1 align="center">Updating stock levels of products</h1>
        <script type="text/javascript">
            var product = new Array();
            <c:forEach var="productTable" begin="0" items="${requestScope.productList}">
            product[${productTable.PID}] = ${productTable.stockLevel};
            </c:forEach>
        </script>
        <form id="updateStockLevelForm" action="updateProductTableServlet" name="updateStockLevelForm" method="post">
            <table id="productTableList" border="3" align="center">
                <tr>
                    <th bgcolor=>Product Name</th>
                    <th bgcolor=>Current stock Level</th>
                    <th bgcolor=>New Stock Level</th>
                </tr>
                <tr>
                    <td><select id="productID" name="productID">
                            <option value="" selected></option>
                            <c:forEach
                                var="productTable" begin="0" items="${requestScope.productList}">
                                <option value=${productTable.PID}>${productTable.productName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <output type="text" value="" id="populateme" name="populateme" />
                    </td>
                    <td><input type="text" id="updateValue" name="updateValue" value="BLANK"/></td>
                </tr>
            </table>
            <div class="center">
                <button class="btn btn-success pull-right" type="submit" id="updateStock">Update</button></div>
        </form>
        <script type="text/javascript">
            document.updateStockLevelForm.productID.onchange = updateText;
            function updateText() {
                var obj_sel = document.updateStockLevelForm.productID;
                document.updateStockLevelForm.populateme.value = product[obj_sel.value];
            }
        </script>
    </body>
</html>
