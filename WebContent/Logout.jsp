

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
       <div style="min-height: 480px;color: #fff;background-color: darkseagreen" align="center">
            <br>
            <div align="left">
                <a href="index.jsp"><img src="images/homeicon.png" width="80px" height="80px"></a>
            </div>
           <%
           session.invalidate();
           %>
            <img src="images/logout.gif">
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
