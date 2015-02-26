<%-- 
    Document   : updateStockLevel
    Created on : 23-Feb-2015, 15:17:49
    Author     : dex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Stock Levels</title>
    </head>
    <body>
        <h1>Updating stock levels of products</h1>
        <script type="text/javascript">
            var product = new Array();
            <c:forEach var="productTable" begin="0" items="${requestScope.productList}">
            product[${productTable.PID}] = ${productTable.stockLevel};
            </c:forEach>
        </script>
        <form id="updateStockLevelForm" action="updateProductTableServlet" name="updateStockLevelForm" method="post">
            <table id="productTableList" border="3">
                <tr>
                    <th bgcolor=>Product Name</th>
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
            <input type="submit" id="updateStock" value="Update stock level"/><br>
        </form>
        <a href="loginOk.jsp"> go back</a><br>
        <script type="text/javascript">
            document.updateStockLevelForm.productID.onchange = updateText;
            function updateText() {
                var obj_sel = document.updateStockLevelForm.productID;
                document.updateStockLevelForm.populateme.value = product[obj_sel.value];
            }
        </script>
    </body>
</html>
