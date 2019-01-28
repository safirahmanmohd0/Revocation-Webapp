/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.io.IOException;
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
@WebServlet(name = "ApproveRequestsServlet", urlPatterns = {"/ApproveRequestsServlet"})
public class ApproveRequestsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String mail = request.getParameter("mail");
            String fname = request.getParameter("fname");
            String skey = request.getParameter("skey");
            String fid = request.getParameter("fid");

            SMTPSend msg = new SMTPSend();
            msg.msgsend(mail, "Hi User\n permission Approved to Download file :" + fname + "\n Security Key :" + skey + "\n NOT SHARABLE");
            Connection con = DbConnection.getConnections();
            String query = "DELETE  FROM request Where fid=? AND mail=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, fid);
            pstmt.setString(2, mail);
            int i = pstmt.executeUpdate();

            if (i == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("SuccessApprove.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
        	e.printStackTrace();
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
