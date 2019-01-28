<%-- 
    Document   : FailRegister
    Created on : Dec 22, 2014, 4:56:45 PM
    Author     : Praveen
--%>


<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RFM Analysis</title>
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
   
            <img src="images/notification_error.png"></br></br>
            <h3>Registration Failed.</h3>
            <br>
            <h4>New User <a href="Register.jsp">Again Register Here</a></h4><br>

        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
