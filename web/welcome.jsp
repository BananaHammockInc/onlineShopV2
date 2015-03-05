<%-- 
    Document   : welcome
    Created on : 17-Feb-2015, 09:47:58
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
        <title>Shop</title>
        <style>
            .body {
                padding-top: 70px;
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

            .thumbnail{
                height: 220px;
                width: 300px;
                margin-bottom: 10px;
                z-index: 100;
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
                width: auto;
            }

            .margin{
                left: 350px;
            }

            .panel {
                max-width: 600px;
                min-width: 600px;
            }

            #left{
                width: 50%;
                float: left;
            }
            #right{
                margin-left: 15%;
                float: right;

            }
            section {
                width: 100%;
                margin: auto;
                padding: 10px;
            }

        </style>
    </head>
    <div class="navbar navbar-default">
        <h1 align="center">Banana Hammock</h1>
        <div class="container-fluid">
            <ul class="nav nav-pills" align="center">
                <li role="presentation" align="center"><a href="login.jsp">Log In</a></li>
                <li role="presentation" align="center"><a href="createCustomer.jsp"> Sign up!</a></li>
                <li role="presentation" align="center" class="pull-right"><a href="index.jsp"> Logout </a><br></li>
                <li role="presentation" align="center"><a href="cart.jsp">View Cart</a></li>
            </ul>
        </div>
    </div>
    <body id="wrapper" class="container"> 
        <section>
            <div id='right'>
                <img class='thumbnail'  src='http://blog.we-love-noro.com/wp-content/uploads/P1020918.jpg'>
                <img class='thumbnail'  src='http://www.joesbananahammock.com/wp-content/uploads/2012/12/4535916_blog-1.jpg'>
                <img class='thumbnail'  src='https://img1.etsystatic.com/001/0/6560133/il_340x270.373008001_oijf.jpg'>
                <img class='thumbnail'  src='https://jewamongyou.files.wordpress.com/2012/02/dragon_fruit.jpg'>
                <img class='thumbnail'  src='https://pbs.twimg.com/media/BtLKYlzIAAIHif6.png'>
            </div>

            <c:forEach var="productTable" begin="0" items="${requestScope.productList}">
                <div id='left'>
                    <ul class="list-group" style='float: left;'>
                        <li class="panel list-group-item">
                            <div class="panel panel-success">
                                <div class="panel-heading">${productTable.productName}&nbsp;&nbsp;</div>
                                <div class="panel-body">${productTable.description}&nbsp;&nbsp;
                                    <p>${productTable.retailPrice}&nbsp;&nbsp;</p>

                                    <form action="<c:url value='addToCart'/>" method="post">
                                        <input type="hidden" name="productId" value=${productTable.PID}>
                                        <button type="submit" class="btn btn-success" name="submit"> Add to Cart</button></form>
                                </div>
                            </div>
                        </li>
                    </ul>
                </c:forEach>
            </div>
        </section>
    </body>
</html>
