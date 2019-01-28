package project.revocation;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.net.ftp.FTPClient;

public class Ftpcon {

    FTPClient client = new FTPClient();
    FileInputStream fis = null;
    boolean status;

    public boolean upload(File file) {
        try {
            client.connect("ftp.drivehq.com");
            client.login("praveenbattina", "nani8");
            this.client.enterLocalPassiveMode();
            this.fis = new FileInputStream(file);
            this.status = this.client.storeFile(" /c/" + file.getName(), this.fis);

            this.client.logout();
            this.fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (status) {
            System.out.println("success");
            return true;
        }
        System.out.println("failed");
        return false;
    }

    public boolean delete(String filename) {
        boolean b=false;
        try {
            client.connect("ftp.drivehq.com");
            client.login("praveenbattina", "nani8");
            client.enterLocalPassiveMode();           
            b = client.deleteFile(" /c/" + filename);

            this.client.logout();
            this.fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (b) {
            System.out.println("success delete");
            return true;
        }
        System.out.println("failed delete");
        return false;
    }
}
