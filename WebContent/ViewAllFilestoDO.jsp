<%-- 
    Document   : ViewAllFilestoDO
    Created on : Mar 6, 2017, 12:13:29 AM
    Author     : Praveen
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div style="min-height: 480px;color: #fff;background-color: darkseagreen" align="center">
            <%@include file="menu.jsp" %>
            <br>
            <h3>Uploaded files in Cloud</h3>
            <br>
            <table width="600px" cellpadding="2" align="center" >
                <tr style="background: yellowgreen">
                    <th>File Id</th>
                    <th>Uploaded By</th>
                    <th>File Name</th>
                    <th>Change <br/>Cipher data</th>
                </tr>
                <%
                    ArrayList list = (ArrayList) request.getAttribute("list");
                    Iterator i = list.iterator();
                    while (i.hasNext()) {
                        Map m = (Map) i.next();
                %>

                <tr style="background-color: lightgreen " align="center">
                    <td>
                        <h4 style="color: #31b2c3"><i>
                                <%
                                    String fid = (String) m.get("fid");
                                    out.println(fid);
                                %>
                        </h4>
                    </td>

                    <td>
                        <h4 style="color: #31b2c3"><i>
                                <%
                                    String uploadBy = (String) m.get("uid");
                                    out.println(uploadBy);
                                %>
                        </h4>
                    </td>
                    <td>
                        <h4 style="color: #31b2c3"><i>
                                <%
                                    String fname=(String)m.get("fname");
                                    out.println(fname);
                                    pageContext.setAttribute("fname", fname);
                                %>
                        </h4>
                    </td>   
                    <td>
                        <h4 style="color: #31b2c3"><i>                             
                                <a href="<%=request.getContextPath()%>/RevocateFileServlet?fname=${fname}">Revocate</a>                       

                        </h4>
                    </td>
            
                </tr>
                <%
                    }
                %>

            </table>



            <br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

