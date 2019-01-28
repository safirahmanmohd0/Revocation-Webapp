<%-- 
    Document   : InvalidLogin
    Created on : May 27, 2015, 5:58:17 PM
    Author     : Praveen
--%>
<%-- 
    Document   : Logout
    Created on : Dec 24, 2014, 3:26:36 PM
    Author     : Praveen
--%>


<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Hybrid ABE</title>
        <style>
            a:hover{
                color: red;
            }
        </style>
    </head>
    <body>
        <div align="center" style="min-height: 480px;color: #fff;background-image: url('images/wallpaper.gif')" >
            <br>
            <div align="left">
                <a href="index.jsp"><img src="images/homeicon.png" width="80px" height="80px"></a>
            </div>
            <br>

            <h2>Dear User you have Entered invalid username/password...</h2>
            <br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
