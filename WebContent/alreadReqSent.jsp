<%-- 
    Document   : alreadReqSent
    Created on : Mar 2, 2017, 3:18:56 AM
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
            <h3>You already Sent the Request</h3>
            <h4>Multiple request not allowed</h4>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>



