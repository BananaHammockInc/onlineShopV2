<%-- 
    Document   : loginOk
    Created on : 10-Feb-2015, 12:08:09
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
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"></link>
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
            
        </style>
    </head>
    <body id="wrapper" class="container">
        <script type="text/javascript">
            try {
                var admin = ${user.admin};
                if(!admin) {
                    window.location.href = "shopFront";
                }
            } catch(err) {
                window.location.href = "index.jsp";
            }
        </script>
        <div class="navbar navbar-default">
           <h1 align='center'>Banana Hammock!</h1>
           <h3 align="right">You are now logged in as: ${user.employee.email}</h3>
           <div class="container">
            <ul class="nav nav-pills">
                <li role="presentation" class=" col-xs-2"><a href="shopFront">Shop</a></li>
                <li role="presentation" class="col-xs-2 pull-right"><a href="index.jsp">Log Out</a></li>
            </ul>
              
        </div>
        </div>
           <div class="wide">
           <div class="btn-group-vertical col-md-6 move-right" role="group" aria-label="false">
                 <button type="button" class="btn btn-default"><a href="createEmployee.jsp"> Create new employee </a></button>
                 <button type="button" class="btn btn-default"><a href="ListEmployee"> Show Employees </a></button>
                 <button type="button" class="btn btn-default"><a href="customerServlet"> Show Customers </a></button>
                 <button type="button" class="btn btn-default"><a href="createSupplier.jsp"> Create new supplier</a></button>
                 <button type="button" class="btn btn-default"><a href="supplierServlet"> Show Suppliers </a></button>
                 <button type="button" class="btn btn-default"><a href="addNewProduct"> Add new product</a></button>
                 <button type="button" class="btn btn-default"><a href="productServlet"> Show products</a></button>
                 <button type="button" class="btn btn-default"><a href="updateStockLevelServlet"> Update stock Level</a></button>
                 <button type="button" class="btn btn-default"><a href="updateCustomerDetails"> Update customer details</a></button>
                 <button type="button" class="btn btn-default"><a href="allPurchases"> See purchases</a></button>
                 
                 
               </div>
            </div>
    </body>
</html>
