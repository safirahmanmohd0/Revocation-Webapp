/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Praveen
 */
@WebServlet(name = "KeyVerificationServlet", urlPatterns = {"/KeyVerificationServlet"})
public class KeyVerificationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String key_entered = request.getParameter("key");
            String fid = request.getParameter("fid");
            System.out.println("key_entered_>"+key_entered);
            System.out.println("fid>"+fid);
            Connection con = DbConnection.getConnections();
            PreparedStatement pstmt = con.prepareStatement("select * from store where fid=?");
            pstmt.setString(1, fid);
            ResultSet rs = pstmt.executeQuery();
            String fname = "";
            String skey = "";
            while (rs.next()) {
                fname = rs.getString("fname");
                skey = rs.getString("skey");
            }
            System.out.println("skey>"+skey);

            request.setAttribute("fname", fname);
            request.setAttribute("skey", skey);
            if (skey.equals(key_entered)) {
                RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("invalidKey.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
