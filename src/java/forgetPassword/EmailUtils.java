/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgetPassword;

import entity.Email;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author hanoon
 */
public class EmailUtils {

    public static void send(Email email) throws Exception {
        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        String gmail ="***";
        String pass ="***";
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(gmail, pass);
            }
        };

        Session session = Session.getInstance(prop, auth);
        try {
            // creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(email.getFrom()));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
            msg.setSubject(email.getSubject());
            msg.setContent(email.getContent(), "text/html ; charset=utf-8");

            // sends the e-mail
           Transport.send(msg);
        } catch (Exception e) {
         e.printStackTrace();
        }

    }
}
