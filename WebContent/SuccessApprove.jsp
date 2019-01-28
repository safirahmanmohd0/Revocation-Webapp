<%-- 
    Document   : SuccessApprove
    Created on : Mar 4, 2017, 12:57:47 AM
    Author     : Praveen
--%>


<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="project.revocation.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div align="center" style="min-height: 480px;color: #fff;background-color:yellow" >
            <table width="1250px"  >
                <tr align="center">
                    <td><a href="AdminSuccessLogin.jsp"><img src="images/homeicon.png" height="100px" width="100px"></a></td>
                    <td style="padding-left:270px"><img src="images/admin.png"></td>
                    <td><a href="Logout.jsp"><img src="images/logout-icon.png" height="60px" width="60px"></a></td>
                </tr>
            </table>
            <br>
            <h3>Approved Successfully</h3>
            <br>
            <img src="images/green-tick.gif" height="100px" width="100px">


            <br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

