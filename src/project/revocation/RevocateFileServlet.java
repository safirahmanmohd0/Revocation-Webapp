/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet(name = "RevocateFileServlet", urlPatterns = {"/RevocateFileServlet"})
public class RevocateFileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fname = request.getParameter("fname");
            String enc_path = "C:/IEEE/store2/";
            File file = new File(enc_path + fname);
            file.delete();
            FileInputStream in = null;
            FileOutputStream out = null;
            in = new FileInputStream("C:/IEEE/store1/" + fname);
            out = new FileOutputStream(enc_path + fname);

            String input = null;
            int c;
            while ((c = in.read()) != -1) {
                if (input == null) {
                    input = Character.toString((char) c);
                } else {
                    input = input + Character.toString((char) c);
                }
            }

            //secure key generation
            String strPssword = KeyGenerator.nextSessionId();;
            AES.setKey(strPssword);
            AES.encrypt(input);
            out.write(AES.getEncryptedString());

            //Delete from cloud
            Ftpcon ftp = new Ftpcon();
            ftp.delete(fname);

            //upload new file to cloud                 
            File f = new File(enc_path + fname);
            ftp.upload(f);


            //update Cipher Key in DB
            DbConnection db = new DbConnection();
            Connection con = db.getConnections();
            String query = "update store set skey=? where fname=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, strPssword);
            pstmt.setString(2, fname);
            int q = pstmt.executeUpdate();

            RequestDispatcher rd = request.getRequestDispatcher("SuccessRevocate.jsp");
            rd.forward(request, response);

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
