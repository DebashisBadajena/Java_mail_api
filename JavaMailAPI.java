/* Add  this dependency before using mail service

<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.x</version>
</dependency>
*/



import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.nxtid.entity.User;

public class MailService {

	private static Session SMTPConfig() {
	
		// SMTP server configuration
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.username", "user_mail_id");
		props.put("mail.smtp.password", "Password");

		// Create a Session object with authentication credentials
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("user_mail_id", "Password or token");
			}
		});
		return session;
	}

	public static void sendMail() {
		
         String htmlBody="<html >"+
		"<head>"+ 
		"</head>"+
		"<body>"+
		    "<h1>This is a Sample mail Message</h1>"+
		"</body>"+
		"</html>";

		try {
			MimeMessage message = new MimeMessage(SMTPConfig());
			message.setFrom(new InternetAddress("sender_mail_id"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(Recipient_mail_id));
		
			message.setSubject("Subject");
			
			message.setContent(htmlBody, "text/html; charset=utf-8");

			// Send the message using the Transport class
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

//create a mail id for project 