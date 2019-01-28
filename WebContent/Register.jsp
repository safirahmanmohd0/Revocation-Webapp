
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revocation</title>
        <style>
            a:hover{
                color: red;
            }
        </style>
        <script>
            function validateForm() {

                var y = document.forms["RegForm"]["mob"].value;
                if (y.length != 10) {
                    alert("Mobile Number should be 10 length");
                    return false;
                }



                if (/\D/.test(y) || y == "")
                {
                    alert("Please enter only numeric mobile(Allowed input:0-9)")
                    return false;
                }

                var mail = document.forms["RegForm"]["uid"].value;
                if (/^([A-Za-z0-9_\-\.])+\@([gmail|GMAIL])+\.(com)$/.test(mail)) {

                } else {
                    alert("not valid mail");
                    return false;

                }
            }
        </script>
        <script>
            $(document).ready(function() {
                $("#gimg").hide();
                $("#rimg").hide();
            });

            function checkduplicateid() {
                var uid = document.getElementById('uid').value;
                $.ajax({
                    url: "DupliacteCheckServlet?uid=" + uid,
                    success: function(data) {
                        if (data.trim() != "Proceed") {
                            alert("USERID--> " + uid + " already exist");
                            $("#rimg").show(1000);
                            $("#gimg").hide();
                            document.getElementById('uid').value = "";
                            return false;
                        } else {
                            $("#gimg").show(1000);
                            $("#rimg").hide();
                        }
                    }

                }
                );
            }
        </script>
    </head>
    <body>
        <div align="center" style="min-height: 480px;color: #fff;background-color: darkseagreen" >
            <br>
            <div align="left">
                <a href="index.jsp"><img src="images/homeicon.png" width="80px" height="80px"></a>
            </div>
            <img src="images/register-now.png" height="90px" width="400px"></br></br>
            <form name="RegForm" action="StoreUserDetails" onsubmit="return validateForm()">
                <table cellpadding="10">
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required=""></td>
                    </tr>
                    <tr>
                        <td>Mail ID:</td>
                        <td><div><input type="text" name="id" required="" id='uid' onblur="return checkduplicateid();">                                
                                <img id='gimg' src="images/green-checkmark.png" height="20px" width="30px">  
                                <img id='rimg' src="images/wrong.gif" height="20px" width="30px">  
                            </div>                        
                        </td>                    

                    </tr>
                    <tr>
                        <td>Mobile No:</td>
                        <td><input type="text" name="mob" required="" maxlength="10"></td>
                    </tr>
                
                    <tr>
                        <td>Choose Password:</td>
                        <td><input type="password" name="pwd" required="" maxlength="10"></td>
                    </tr>

                    <tr>
                        <td>User Type:
                        </td>
                        <td>
                            <select name="utype">
                                <option>...select...</option>
                                <option value="do">Data Owner</option>
                                <option value="du">Data User</option>
                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td align="center" colspan="2"><input type="submit" value="Register" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff ">
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff "></td>
                    </tr>

                </table>
            </form>
            <br><br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
