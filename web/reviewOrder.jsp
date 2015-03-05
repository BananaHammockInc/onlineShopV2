<%-- 
    Document   : reviewOrder
    Created on : 02-Mar-2015, 23:22:09
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="confirmOrder" method="post">
        <table id="orderReview" border="3">
            <tr>
                <th bgcolor=>Product name</th>
                <th bgcolor=>Quantity</th>
            </tr>

            <c:forEach var="cartItem" begin="0" items="${user.cart.items}">
                <c:set var="productTable" value="${cartItem.product}"/>
                <tr>
                    <td>
                        ${productTable.productName}
                    </td>
                    <td>
                        ${cartItem.quantity}
                    </td>
                </tr>
            </c:forEach>
        </table>
            <input type="submit" name="submit" value="Canfirm Order">
        </form>
        <a href="supplierLogin.jsp">back</a>
    </body>
</html>
