
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
            <h2>Upload Files Here</h2>
            <br>

            <form  action="FileUploadingServlet" method="post" enctype="multipart/form-data">

                <table width="400px" cellpadding="8px">              
                    <tr>
                        <td>Upload Here:</td>
                        <td><input type="file" name="file" style="width: 170px"></td>
                    </tr>
                                    
                    <tr>
                        <td align="center" colspan="2"><input type="submit" value="Upload" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff;border-radius: 10px ">
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff;border-radius: 10px "></td>
                    </tr>

                </table>
            </form>
            <br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

