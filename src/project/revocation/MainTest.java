/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Praveen
 */
public class MainTest {

    public static void main(String arg[]) {
        try {
            FTPClient client = new FTPClient();
            String filename = "databasecon.java";

            String name = filename;
            client.connect("ftp.drivehq.com");
            client.login("praveenbattina", "nani8");
            client.enterLocalPassiveMode();

            boolean f = client.deleteFile(" /c/" + name);
            System.out.println("f-->" + f);
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
