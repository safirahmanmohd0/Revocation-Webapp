<%-- 
    Document   : AskKeyToDownload
    Created on : Mar 4, 2017, 1:12:36 AM
    Author     : Praveen
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String fid=request.getParameter("fid");
request.setAttribute("fid", fid);
%>
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
        <div align="center" style="min-height: 480px;color: #fff;background-color:yellow" >
            <%@include file="menu_du.jsp" %>
            <br>
            <h3>Enter Security key</h3>
            <img src="images/download-logo-260x300.png" height="100px" width="100px">
            <form action="KeyVerificationServlet" method="POST">
                <table style="width: 500px">
                    <tr>
                        <td>Key:</td>
                        <td><input type="password" name="key"><input type="hidden" name="fid" value="<%=fid%>"></td>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </table>

            </form>

        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>


