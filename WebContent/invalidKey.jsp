<%-- 
    Document   : invalidKey
    Created on : Mar 4, 2017, 1:36:39 AM
    Author     : Praveen
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style>
            a:hover{
                color: red;
            }
        </style>
    </head>
    <body>
        <div align="center" style="min-height: 480px;color: #fff;background-color:darkseagreen" >
            <%@include file="menu_du.jsp" %>
            <br>
            <h3>You have entered invalid key</h3>
            <br>
            <img src="images/red.png" height="100px" width="100px">
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>



