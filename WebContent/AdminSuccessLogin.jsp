
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
        <style>
            table {
                border-collapse: collapse;                
            }

            th, td {
                text-align: left;
                padding: 10px;
            }

            tr:nth-child(even){background-color:	#DCDCDC}

            th {
                background-color: #4CAF50;
                color: #fff;
            }
            td {
                color: yellow;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div align="center" style="min-height: 480px;color: #fff;background-color:darkseagreen" >
            <table width="1250px"  >
                <tr align="center">
                    <td><a href="AdminSuccessLogin.jsp"><img src="images/homeicon.png" height="100px" width="100px"></a></td>
                    <td style="padding-left:270px"><img src="images/admin.png"></td>
                    <td><a href="Logout.jsp"><img src="images/logout-icon.png" height="60px" width="60px"></a></td>
                </tr>
            </table>
            <br>
            <h3>Requests For Cipher Key</h3>
            <table>
                <tr>
                    <th>Requested By</th>
                    <th>File Name</th>
                    <th>Approve</th>
                </tr>

                <%
                    Connection con = DbConnection.getConnections();
                    String query = "SELECT r.mail,s.fname,s.skey,s.fid FROM request r,store s WHERE s.fid=r.fid AND r.status=?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, "H");
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        String mail = rs.getString("mail");
                        String fname = rs.getString("fname");
                        String skey = rs.getString("skey");
                        String fid = rs.getString("fid");
                %>  
                <tr>
                    <td><%=mail%></td>
                    <td><%=fname%></td> 
                    <td><a href="<%=request.getContextPath()%>/ApproveRequestsServlet?mail=<%=mail%>&fname=<%=fname%>&skey=<%=skey%>&fid=<%=fid%>">Approve</a></td> 
                </tr>
                <%}%>
                </tr>
            </table>

            <br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

