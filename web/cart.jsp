<%-- 
    Document   : cart
    Created on : 24-Feb-2015, 20:20:39
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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"></link>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<c:set var="view" value="/cart" scope="session"/>
<html>
    <head>
        <title> Shopping Cart </title>
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
        </style>
    </head>
    <body id="wrapper" class="container">
        <div class="navbar navbar-default">
            <h1 align="center">Banana Hammock</h1>
            <div class="container-fluid">
                <ul class="nav nav-pills" align="center">
                    <li role="presentation" align="center" class="pull-right"><a href="index.jsp"> Logout </a><br></li>

                </ul>
            </div>
        </div>
        <button class="btn btn-info pull-left"><a href="welcome.jsp">Continue shopping</a></button>

        <p align="center"> your Cart Contains ${user.cart.numberOfItems} items.</p>

        
            <c:if test="${!empty user.cart && user.cart.numberOfItems != 0}">
                <h4 id="subtotal">Cart Total: ${user.cart.total}  </h4>
                <table align="center" id="cartTable">
                    <tr class="header">
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Subtotal</th>
                    </tr>
                    <c:forEach var="cartItem" items="${user.cart.items}" >
                        <c:set var="productTable" value="${cartItem.product}" />
                        <tr>
                            <td> ${productTable.productName}</td>
                            <td>
                                <form action="updateCart" method="post">
                                <input type="hidden" name="productId" value="${productTable.PID}">
                                <input type="number" name="quantity" value="${cartItem.quantity}">
                                
                                    <input type="submit" name="submit" value="update">
                                </form>
                            </td>
                            <td> ${cartItem.total} </td>
                            </tr>
                        </c:forEach>
                </table>
            </c:if>
                
        <form action="<c:url value='CheckOut'/>" method="post">
            <button class="btn btn-success pull-right" type="submit" name="submit">Proceed to check out</button>
        </form>
    </body>
</html>