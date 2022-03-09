package financeApp;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  


public class SendEmail {

		public static void sendMail(String recipient) throws Exception {    
		    
			System.out.print("preparing");

		      // Sender's email ID needs to be mentioned
		      final String from = "xxxxx@gmail.com";
		      final String password = "xxxxx";
		      //final String recipient = "aidinatt8@gmail.com";

		      // Assuming you are sending email from localhost
		      String host = "smtp.gmail.com";

		      // Get system properties
		      Properties properties = new Properties();

		      // Setup mail server
		      properties.put("mail.smtp.auth", "true");
		      properties.put("mail.smtp.starttls.enable", "true");
		      properties.put("mail.smtp.host", host);
		      properties.put("mail.smtp.port", "587");
		      properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	          properties.put("mail.smtp.debug", "true");

		      // Get the default Session object.
		      Session session = Session.getInstance(properties, new Authenticator() {
		    	  @Override
		    	  protected PasswordAuthentication getPasswordAuthentication() {
		    		  return new PasswordAuthentication(from, password);
		    	  }
		      });
		      
		      Message message = prepareMessage(session, from, recipient);
		     
		      Transport.send(message);
		      System.out.print("Message sent");
		      
	}
		private static Message prepareMessage (Session session, String from, String recipient) {
	    	  
	    	  try {
	    		 Message message = new MimeMessage(session);
				message.setFrom(new  InternetAddress(from));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
				message.setSubject("Notification: your stocks values");
				message.setText("Your total stocks are experiencing a loss right now. \nPlease, check and take appropriate actions.\nYour Finance App");
				return message;
				
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
	    	  return null;
	    	  
	      }

}