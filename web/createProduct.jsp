<%-- 
    Document   : createProduct
    Created on : 23-Feb-2015, 11:52:19
    Author     : dex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new product</title>
    </head>
    <body>
        <h1>Add a new product to the database</h1>
        <h2>Pick supplier</h2>

        <form id="createProductForm" action="newProductServlet" method="post">
            <table>
                <tr><td>Product Name:</td><td><input type="text" id="productName" name="productName"/></td></tr>
                <tr><td>Description:</td><td><input type="text" id="UserPassword" name="description"/></td></tr>
                <tr><td>Wholesale Price:</td><td><input type="number" id="wholesalePrice" name="wholesalePrice"/></td></tr>
                <tr><td>Retail Price:</td><td><input type="number" id="retailPrice" name="retailPrice"/></td></tr>
                <tr><td>Stock level:</td><td><input type="number" id="stockLevel" name="stockLevel"/></td></tr>
                <tr><td>Supplier:</td><td><select name="supplierName">
                            <c:forEach var="supplierTable" begin="0" items="${requestScope.supplierList}">
                                <option value=${supplierTable.SID}>${supplierTable.businessName}</option>
                            </c:forEach>
                        </select></td></tr>
            </table>
            <input type="submit" id="createProduct" value="Add new product"/>
        </form>
        <a href="loginOk.jsp"> go back</a>
    </body>
</html>
