<%-- 
    Document   : cart
    Created on : 24-Feb-2015, 20:20:39
    Author     : dex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:set var="view" value="/cart" scope="session"/>
<html>
    <head>
        <title> Shopping Cart </title>
    </head>
    <body>

        <p> your Cart Contains ${cart.numberOfItems} items.</p>
        <a href="shopFront" >Continue Shopping</a>
    <c:if test="${!empty cart && cart.numberOfItems != 0}">
        <h4 id="subtotal">Cart Total: ${cart.total}  </h4>
        <table id="cartTable">
            <tr class="header">
                <th>Name</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
            <c:forEach var="cartItem" items="${cart.items}" >
                <c:set var="productTable" value="${cartItem.product}" />
                <tr>
                    <td> ${productTable.productName}</td>
                    <td>
                        <form action="<c:url value='updateCart'/>" method="post">
                            <input type="hidden"  
                                   name="productId" 
                                   value="${productTable.PID}">
                            <input type="text"  
                                   maxlength="2"
                                   size="2" 
                                   value="${cartItem.quantity}" 
                                   name="quantity" 
                                   style="margin:5px">
                            <input type="submit" 
                                   name="submit" 
                                   value="update">
                        </form>
                    </td>
                    <td> ${cartItem.total} </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>