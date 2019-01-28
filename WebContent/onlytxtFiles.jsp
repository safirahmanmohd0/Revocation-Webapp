<%-- 
    Document   : onlytxtFiles
    Created on : Mar 25, 2016, 1:10:08 PM
    Author     : Praveen
--%>


<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hybrid ABE</title>
    </head>
    <body>
        <div style="min-height: 480px;color: #fff;background-image: url('images/wallpaper.gif')" align="center">

            <table width="1250px"  >
                <tr align="center">
                    <td><a href="SuccessUserLogin.jsp"><img src="images/homeicon.png" height="100px" width="100px"></a></td>
                    <td><a href="Upload.jsp"><img src="images/upload-button.png" height="80px" width="90px"></a> </td>
                    <td><a href="ViewFilesServlet"><img src="images/download.png" height="100px" width="120px"></a></td>
                    <td><a href="Logout.jsp"><img src="images/logout-icon.png" height="60px" width="60px"></a></td>
                </tr>
            </table>
            <br>
          
         
            
            <h2>Only <i style="color: yellow">txt</i> files are allowed to cloud</h2>           
            
            <img src="images/txt.png" height="250px" width="200px">

            <br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

