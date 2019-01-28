<%-- 
    Document   : viewFile
    Created on : Apr 10, 2017, 1:10:13 AM
    Author     : Praveen
--%>
<script>
    setTimeout(function() {
        window.location = 'Login.jsp';
    }, 30000);
</script>
<%@page import="java.io.InputStream"%>
<%@page import="project.revocation.AES"%>
<%@page import="org.apache.commons.net.ftp.FTPClient"%>
<%@include file="header.jsp" %>
 <%@include file="menu_du.jsp" %>
<%    
    String mail = (String) session.getAttribute("mail");
    String md = null;
    if (mail.equals(md)) {
        response.sendRedirect("http://localhost:8084/revocation/Login.jsp");
    }
    
    String AESkey = request.getParameter("skey");
    FTPClient client = new FTPClient();
    //  ServletOutputStream fos = response.getOutputStream();
    String filename = request.getParameter("fname");
    
    String name = filename;
    client.connect("ftp.drivehq.com");
    client.login("praveenbattina", "nani8");
    client.enterLocalPassiveMode();
    int c;
    InputStream is = client.retrieveFileStream(" /c/" + name);
    String input = null;
    while ((c = is.read()) != -1) {
        
        if (input == null) {
            input = Character.toString((char) c);
        } else {
            input = input + Character.toString((char) c);
        }
        
    }
    
    
    String strPssword = AESkey;
    AES.setKey(strPssword);
    
    AES.decrypt(input.getBytes());
    String data = AES.getDecryptedString();
    out.println(data);
    
    
    
    

%>