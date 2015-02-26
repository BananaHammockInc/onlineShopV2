<%-- 
    Document   : updateCustomerDetails
    Created on : 24-Feb-2015, 11:06:51
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
        <h1>Hello World!</h1>
        <script type="text/javascript">
            var customers = new Array();
            <c:forEach var="customerTable" begin="0" items="${requestScope.customerList}">
            customers[${customerTable.CID}] = "${customerTable.email}";
            </c:forEach>
            for (var i = 0; i < customers.length; i++) {
                console.log(customers[i]);
            }
        </script>
        <form id="customerUpdateForm" action="updateCustomer" name="customerUpdateForm" method="post">
            <table id="customerUpdateTable" border="3">
                <tr>
                    <th bgcolor=>Email</th>
                    <th bgcolor=>Current Email</th>
                    <th bgcolor=>New Email</th>
                </tr>
                <tr>
                    <td>
                <select id="customerEmail" name="customerEmail">
                    <option value="" selected></option>
                    <c:forEach var="customerTable" begin="0" items="${requestScope.customerList}">
                        <option value=${customerTable.CID}>${customerTable.email}</option>
                    </c:forEach>
                </select>
                    </td>
                    <td><output type="text" value="" id="populatemeEmail" name="populatemeEmail"/></td>
                    <td><input type="text" value="" id="updatedEmail" name="updatedEmail"/></td>
                </tr>
            </table>
            <input type="submit" id="updateCustomer" value="subbmit updated information"/>
        </form>
        <a href="loginOk.jsp"> go back</a>
        <script type="text/javascript">
        document.customerUpdateForm.customerEmail.onchange = updateText;

        function updateText() {
            var obj_sel = document.customerUpdateForm.customerEmail;
            document.customerUpdateForm.populatemeEmail.value = customers[obj_sel.value];
        }
    </script>
    </body>
    <script type="text/javascript">
        // Pre populated array of data
        var myData = new Array();
        myData[1] = 'Some text';
        myData[2] = 'Some other text';
    </script>     
    <form id="example" name="example">
        <select id="selector" name="selector">
            <option value="" selected></option>
            <option value=1>One</option>
            <option value=2>Two</option>
        </select>
        <br />
        <input type="text" value="" id="populateme" name="populateme" />
    </form>

    <script type="text/javascript">
        document.example.selector.onchange = updateText;

        function updateText() {
            var obj_sel = document.example.selector;
            document.example.populateme.value = myData[obj_sel.value];
        }
    </script>

</html>
