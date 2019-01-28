/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Praveen
 */
@WebServlet(name = "FTPDownloadFromCloud", urlPatterns = {"/FTPDownloadFromCloud"})
public class FTPDownloadFromCloud extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            HttpSession session = request.getSession(false);
            String AESkey = request.getParameter("skey");
            System.out.println("AESkey>"+AESkey);
            FTPClient client = new FTPClient();
            ServletOutputStream fos = response.getOutputStream();
            String filename = request.getParameter("fname");

            String name = filename;
            client.connect("ftp.drivehq.com");
            client.login("praveenbattina", "nani8");
            client.enterLocalPassiveMode();

            // Fetch file from server 
            if (name.toLowerCase().contains("flv")) {
                response.setContentType("video/x-flv");
            } else if (name.toLowerCase().contains("mp3")) {
                response.setContentType("audio/mpeg");
            } else if (name.toLowerCase().contains("doc")) {
                response.setContentType("application/msword");
            } else if (name.toLowerCase().contains("docx")) {
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            }

            response.setHeader("Content-Disposition", "attachment; filename=" + name);

            //client.retrieveFile(" /c/" + filename, fos);
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
            String out = AES.getDecryptedString();
            fos.write(out.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
