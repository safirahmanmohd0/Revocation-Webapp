/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

/**
 *
 * @author Praveen
 */
@WebServlet(urlPatterns = {"/FileUploadingServlet"})
public class FileUploadingServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        PreparedStatement pstmt = null;
        con = DbConnection.getConnections();
        try {
            HttpSession seesion = request.getSession(false);
            String mail = (String) seesion.getAttribute("mail");

            String path = "C:/IEEE/store1/";
            String enc_path = "C:/IEEE/store2/";

            UploadBean upb = new UploadBean();
            upb.setFolderstore(path);
            upb.setOverwrite(false);
            Hashtable ht;
            UploadFile curfile;
            /* create a parser for parsing form data */
            MultipartFormDataRequest nreq = new MultipartFormDataRequest(request);
            ht = nreq.getFiles();
            Enumeration files = ht.elements();
            while (files.hasMoreElements()) {
                curfile = (UploadFile) files.nextElement();
                String path1 = curfile.getFileName();
                String filenameSplit[] = path1.split(".");
                String q1 = "select * from store where fname=?";
                PreparedStatement pst = con.prepareStatement(q1);
                pst.setString(1, path1);
                ResultSet rss = pst.executeQuery();
                if (rss.next()) {
                    RequestDispatcher rd = request.getRequestDispatcher("DuplicateFilename.jsp");
                    rd.forward(request, response);
                } else {
                    if (!path1.endsWith("txt")) {
                        RequestDispatcher rd = request.getRequestDispatcher("onlytxtFiles.jsp");
                        rd.forward(request, response);
                    } else {
                        upb.store(nreq);

                        FileInputStream in = null;
                        FileOutputStream out = null;
                        in = new FileInputStream("C:/IEEE/store1/" + path1);
                        out = new FileOutputStream(enc_path + path1);

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


                        //upload to cloud                 
                        File f = new File(enc_path + path1);
                        Ftpcon ftp = new Ftpcon();
                        ftp.upload(f);

                        DbConnection db = new DbConnection();
                        con = db.getConnections();
                        String query = "insert into store(uid,fname,skey) values(?,?,?)";
                        pstmt = con.prepareStatement(query);
                        pstmt.setString(1, mail);
                        pstmt.setString(2, path1);
                        pstmt.setString(3, strPssword);              
                        int q = pstmt.executeUpdate();
                        
                        RequestDispatcher rd = request.getRequestDispatcher("SuccessUpload.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
