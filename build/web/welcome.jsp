<%-- 
    Document   : welcome
    Created on : 17-Feb-2015, 09:47:58
    Author     : dex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"</link>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <style>
            .body {
                padding-top: 70px;
            }

        </style>
    </head>
    <div class="jumbotron">
         <h1 align="center">Banana Hammock</h1>
         <div class="container-fluid">
            <ul class="nav nav-pills" align="center">
                <li role="presentation" align="center"><a href="login.jsp">Log In</a></li>
                <li role="presentation" align="center"><a href="createCustomer.jsp"> Sign up!</a></li>
                <li role="presentation" align="center"><a href="index.jsp"> Logout </a><br></li>
            </ul>
        </div>
         </div>
    <h1>List of Products</h1>
<table id="ProductTable" border="3">
<tr >
    <th >Name</th>
    <th >Description</th>
    <th >Retail Price</th>
</tr>
<c:forEach var="productTable" begin="0" items="${requestScope.productList}">
<tr>
    <td>${productTable.productName}&nbsp;&nbsp;</td> 
    <td>${productTable.description}&nbsp;&nbsp;</td> 
    <td>${productTable.retailPrice}&nbsp;&nbsp;</td> 
    <td>
                  <form action="<c:url value='addToCart'/>" method="post">
                        <input type="number"
                               name="productId"
                               value=${productTable.PID}>
                        <input type="submit"
                               name="submit"
                               value="add to cart"post="addToCart">
                    </form>
                </td>
</tr> 
</c:forEach>
</table>
    <form action="viewCart" method="post">
        <input type="submit" name="submit" value="view cart">
    </form>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item</h3>
                         <p> Description of item</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
                 
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item2</h3>
                         <p> Description of item2</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item3</h3>
                         <p> Description of item3</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item3</h3>
                         <p> Description of item3</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item3</h3>
                         <p> Description of item3</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item3</h3>
                         <p> Description of item3</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item3</h3>
                         <p> Description of item3</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item3</h3>
                         <p> Description of item3</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
    <div class="row-fluid">
             <div class="col-sm-6 col-md-4">
                 <div class="thumbnail">
                     <img src="..." alt="...">
                     <div class="caption">
                         <h3>Item3</h3>
                         <p> Description of item3</p>
                         <p><a href="#" class="btn btn-primary" role="button">Add to cart</a></p>
                     </div>
                 </div>
             </div>
        </div>
</html>
