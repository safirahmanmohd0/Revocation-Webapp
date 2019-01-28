<%-- 
    Document   : ViewAllFiles
    Created on : May 19, 2015, 1:21:27 AM
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
            <%@include file="menu_du.jsp" %>
            <br>
            <h3>Uploaded files in Cloud</h3>
            <br>
            <table width="600px" cellpadding="2" align="center" >
                <tr style="background: yellowgreen">
                    <th>File Id</th>
                    <th>Uploaded By</th>
                    <th>File Name</th>
                    <th>Send Request<br/>For Cipher key</th>
                    <th>Download</th>
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
                                    pageContext.setAttribute("fid", fid);
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
                                    out.println(m.get("fname"));
                                %>
                        </h4>
                    </td>   
                    <td>
                        <h4 style="color: #31b2c3"><i>                             
                                <a href="<%=request.getContextPath()%>/SendRequestServlet?fid=${fid}">Send Request</a>                       

                        </h4>
                    </td>
                    <td>
                        <h4 style="color: #31b2c3"><i>
                                <a href="<%=request.getContextPath()%>/AskKeyToDownload.jsp?fid=${fid}">Download</a>
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

