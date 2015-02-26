<%-- 
    Document   : index
    Created on : 09-Feb-2015, 18:55:11
    Author     : dex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"</link>
<!DOCTYPE html>
<html>
    <%
            Cookie[] oldCookies = request.getCookies();
            for(int i = 0; i < oldCookies.length; i++) {
                oldCookies[i].setMaxAge(0);
                oldCookies[i].setValue("");
            }
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
        <style>
            .wide {
                width: 100%;
                height: 500px;
                background-image: url('http://s7d9.scene7.com/is/image/BedBathandBeyond/189710525586p?$478$');
            }
            .wide image {
                width: 100%;
            }
            
            .line {
                padding-top: 10px;
                overflow: hidden;
                text-align: center;
            }
            
            .logo {
                color: #000;
                text-align: center;
            }
        </style>
    </head>
    
    <div class="jumbotron">
         <h1>Welcome to Banana Hammock!</h1>
         <p> Welcome to Banana Hammock's online fruit and vegetable store!</p>
         <p><a class="btn btn-primary btn-lg" href="login.jsp" role="button"> Start Shopping</a></p>
        </div>
    <div class="wide"> 
            <div class="col-xs-4 line"><hr></div>
            <div class="col-xs-4 logo">I AM A BANANA</div>
            <div class="col-xs-4 line"><hr></div>
    </div>
</html>
