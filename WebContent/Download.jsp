<%-- 
    Document   : Download
    Created on : Mar 4, 2017, 1:42:30 AM
    Author     : Praveen
--%>
<%
String skey = (String)request.getAttribute("skey");
String fname = (String)request.getAttribute("fname");
%>

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
            <h3>Download File Here</h3>

            <table width="600px">
                <tr>
                    <td>
                        <img src="images/download-logo-260x300.png" height="200px" width="200px">
                    </td>

                    <td>


                        <h4>VIEW :  
                            <a href="<%=request.getContextPath()%>/viewFile.jsp?fname=<%=fname%>&skey=<%=skey%>">Click Here</a>
                        </h4>


                    </td>
                </tr>
            </table>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>



