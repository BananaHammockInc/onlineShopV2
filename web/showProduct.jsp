<%-- 
    Document   : showProduct
    Created on : 23-Feb-2015, 14:21:35
    Author     : dex
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
        <h1>All products</h1>
        <table id="productTableList" border="3">
            <tr >
                <th bgcolor=>ID</th>
                <th bgcolor=>Product Name</th>
                <th bgcolor=>Description</th>
                <th bgcolor=>Wholesale Price</th>
                <th bgcolor=>Retail Price</th>
                <th bgcolor=>Stock Level</th>
                <th bgcolor=>Supplier ID</th>
            </tr>
            <c:forEach
                var="productTable" begin="0" items="${requestScope.productList}">
                <tr>
                    <td>${productTable.PID}&nbsp;&nbsp;</td>
                    <td>${productTable.productName}&nbsp;&nbsp;</td>
                    <td>${productTable.description}&nbsp;&nbsp;</td>
                    <td>${productTable.wholesalePrice}&nbsp;&nbsp;</td>
                    <td>${productTable.retailPrice}&nbsp;&nbsp;</td>
                    <td>${productTable.stockLevel}&nbsp;&nbsp;</td>
                    <td>${productTable.supplierID}&nbsp;&nbsp;</td>
                </tr> 
            </c:forEach>
        </table>
        <a href="loginOk.jsp"> go back</a>
    </body>
</html>
