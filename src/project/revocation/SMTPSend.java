/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Praveen
 */

public class SMTPSend {
    
   
    
        String username = "safiuz199@gmail.com";
        String password = "jacksparrow893";
        String smtphost = "smtp.gmail.com";
        String compression = "Security Verification code:";
        String from = "safiuz199@gmail.com";
        String to = "";
        String body = "";
        Transport tr = null;

    public void msgsend( String to,String body) {
       this.to=to;
       this.body=body;
       
        try {
         Properties props = System.getProperties();
      //   props.put("mail.smtp.auth", "true");
        // props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
         // Get a Session object
         Session mailSession = Session.getDefaultInstance(props, null);

         // construct the message
         Message msg = new MimeMessage(mailSession);

         //Set message attributes
         msg.setFrom(new InternetAddress(from));
         InternetAddress[] address = {new InternetAddress(to)};
         msg.setRecipients(Message.RecipientType.TO, address);
         msg.setSubject(compression);
         msg.setText(body);
         msg.setSentDate(new Date());

         tr = mailSession.getTransport("smtp");
         tr.connect(smtphost, username, password);
         msg.saveChanges();
         tr.sendMessage(msg, msg.getAllRecipients());
         tr.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

      
    
}
