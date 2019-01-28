/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Praveen
 */
@WebServlet(urlPatterns = "/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) {

        try {
            String username = request.getParameter("uname");
            String password = request.getParameter("pwd");
            Connection con = DbConnection.getConnections();
            String query = "select * from userdetails where mail=? and pwd=?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession(true);
                String utype = rs.getString("utype");
                session.setAttribute("utype", utype);
                session.setAttribute("name", rs.getString("name"));
                session.setAttribute("mail", rs.getString("mail"));
                if (utype.equals("do")) {
                    RequestDispatcher rd = request.getRequestDispatcher("SuccessDataOwnerLogin.jsp");
                    rd.forward(request, response);
                }
                if (utype.equals("du")) {
                    RequestDispatcher rd = request.getRequestDispatcher("SuccessDataUserLogin.jsp");
                    rd.forward(request, response);
                }
            } else {
                if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)) {
                    RequestDispatcher rd = request.getRequestDispatcher("AdminSuccessLogin.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("InvalidLogin.jsp");
                    rd.forward(request, response);
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
