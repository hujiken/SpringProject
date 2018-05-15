package service.email;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import model.email.ProductOrder;

@Service("mailService")
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(Object object) {
		ProductOrder order = (ProductOrder) object;
		MimeMessagePreparator preparator = getMessagePreparator(order);
		try {
			mailSender.send(preparator);
			System.out.println("Message Send...");
		} catch (MailException e) {
			System.err.println(e.getMessage());
		}
	}

	private MimeMessagePreparator getMessagePreparator(final ProductOrder order) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom();
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(order.getCustomerInfo().getEmail()));
				mimeMessage.setText("Xin chao " + order.getCustomerInfo().getName() 
						+ ", cam on ban da dat hang. Ma san pham cua ban la " + order.getOrderId() + ".");
				mimeMessage.setSubject("Gui mail bang Spring");
				String emailBody = "<p style='color: red'>Demo send HTML from Spring<p>";
				mimeMessage.setContent(emailBody, "text/html");
			}
		};
		return preparator;
	}
}
