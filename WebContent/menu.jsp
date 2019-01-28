<%-- 
    Document   : menu
    Created on : Jan 7, 2017, 10:42:45 PM
    Author     : Praveen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>
</head>
<body>

<ul>
  <li><a href="SuccessDataOwnerLogin.jsp">Home</a></li>  
  <li><a href="Upload.jsp">Upload</a></li> 
  <li><a href="RetriveAllFilesServlet">Revocate</a></li> 
  <li style="padding-left: 350px"><a href="#about">Welcome to <b style="color:lightgreen">${name}</b>&nbsp;&nbsp;(DATA OWNER)</a></li>
  <li style="padding-left: 16%"><a href="Logout.jsp" style="color: red">Logout</a></li> 
</ul>
</body>
</html>
