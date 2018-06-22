package banana.db.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import banana.main.objects.EmailObject;

public class EmailSender {
	
	public static void sendEmail(EmailObject email) {

		try {
			
			Properties props = System.getProperties();
			props.put("mail.smtps.host", "");
			props.put("mail.smtps.auth", "true");
			Session s = Session.getInstance(props);
			
			MimeMessage msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress("fireandaiz@gmail.com"));

			Address[] toAddr = new Address[email.getTo().size()];
			for (int i=0; i<email.getTo().size(); i++) {
				toAddr[i] = new InternetAddress(email.getTo().get(i));
			}
			msg.setRecipients(RecipientType.TO, toAddr);
			
			Address[] ccAddr = new Address[email.getCc().size()];
			for (int i=0; i<email.getCc().size(); i++) {
				ccAddr[i] = new InternetAddress(email.getCc().get(i));
			}
			msg.setSentDate(new Date());
			
			Transport.send(msg, "fireandaiz@gmail.com", "doordonotthereisnotry");
			
			
		} catch (AddressException ex) {
			//TODO: print stack trace
		} catch (MessagingException ex) {
			//TODO: print stack trace
		}
		
	}
	
}
